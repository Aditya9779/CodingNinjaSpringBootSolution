package com.cn.hotel.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationOwnFilter_Token_Coming extends OncePerRequestFilter {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private JwtDecoderOwn jwtDecoderOwn;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestHeader = request.getHeader("Authorization");
        //This request comes in this format (Bearer ajldskfhdajghajkdshjkdghas)
        //first always Bearer is their then some random coded string
        String token = "";
        String username = "";
        if (requestHeader != null && requestHeader.startsWith("Bearer")) {
            //This we are doing because we have the encoded string as a tocken
            token = requestHeader.substring(7);
            username = jwtDecoderOwn.getUserNameFromToken(token);
            if (username != null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (jwtDecoderOwn.isTokenExpired(token) && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UsernamePasswordAuthenticationToken usernamePasAuTo = new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
                    //For taking all the details from the request because its has all thing
                    //WebAuthenticationDetailsSource this is use for building the object
                    usernamePasAuTo.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    //This is used for storing the deaitls in securitcontextholder so
                    //no one take this from our
                    SecurityContextHolder.getContext().setAuthentication(usernamePasAuTo);
                }
            }

        }
        filterChain.doFilter(request, response);
    }
}
