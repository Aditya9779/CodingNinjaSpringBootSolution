package com.cn.hotel.service;

import com.cn.hotel.jwt.JwtDecoderOwn;
import com.cn.hotel.model.JwtRequest;
import com.cn.hotel.model.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class JwtAuthService {
    @Autowired
    AuthenticationManager manager;
    @Autowired
    JwtDecoderOwn jwtDecoderOwn;
    @Autowired
    UserDetailsService userDetailsService;

    public JwtResponse login(JwtRequest jwtRequest) {
        //Checking the User if its valid or not
        this.doAuthenticate(jwtRequest.getName(), jwtRequest.getPassword());

        //Generating the Token
        //Its take the UserDetails for taking  encode it
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getName());
        String token = jwtDecoderOwn.generateToken(userDetails);
        JwtResponse response = JwtResponse.builder().jwtToken(token).build();
        return response;
    }

    private void doAuthenticate(String name, String password) {
        //This is used for creating the Authentication object
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(name, password);
        try {
            manager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Not Found ");
        }
    }
}
