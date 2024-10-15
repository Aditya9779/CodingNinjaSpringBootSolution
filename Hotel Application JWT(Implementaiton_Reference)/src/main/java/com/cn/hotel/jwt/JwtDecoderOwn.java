package com.cn.hotel.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class JwtDecoderOwn {
    private static final long JWT_TOKEN_VALIDITY = 60 * 60;//Time In Seconds
    private String secret = "jahfdj;sghjadhgdajksgadsfdasfga";

    public String getUserNameFromToken(String token) {
        Claims claims = getAllClaimsFromToken(token);
        String username = claims.getSubject();
        return username;
    }
    //This is the method for decoding the token
    //Claims offer the different methods for the decoding
    // to providing the methods

    private Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parserBuilder()
                    .setSigningKey(secret.getBytes()).build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    //Checking for the Date is its expired or not
    public boolean isTokenExpired(String token) {
        Claims claims = getAllClaimsFromToken(token);
        Date expiaryDate = claims.getExpiration();
        return expiaryDate.before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Objects> claims = new HashMap<>();
        return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS512.getJcaName()), SignatureAlgorithm.HS512).compact();
    }
}
