package com.cn.hotel.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtAuthenticationHelper {

	
	private String secret = "thisisacodingninjasdemonstrationforsecretkeyinspringsecurityjsonwebtokenauthentication";
	private static final long JWT_TOKEN_VALIDITY = 60*60;
	Logger logger = LoggerFactory.getLogger(JwtAuthenticationHelper.class);
	
	public String getUsernameFromToken(String token)
	{
		Claims claims =  getClaimsFromToken(token);
		return claims.getSubject();
	}
	
	public Claims getClaimsFromToken(String token)
	{
		Claims claims = Jwts.parserBuilder().setSigningKey(secret.getBytes())
				.build().parseClaimsJws(token).getBody();
		return claims;
	}
	
	public Boolean isTokenExpired(String token)
	{
		Claims claims =  getClaimsFromToken(token);
		Date expDate = claims.getExpiration();
		return expDate.before(new Date());
	}

	public String generateToken(UserDetails userDetails) {
		logger.info("JWT Authentication");
		Map<String,Object> claims = new HashMap<>();
		
		return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000))
		.signWith(new SecretKeySpec(secret.getBytes(),SignatureAlgorithm.HS512.getJcaName()),SignatureAlgorithm.HS512)
		.compact();
	}
	
}
