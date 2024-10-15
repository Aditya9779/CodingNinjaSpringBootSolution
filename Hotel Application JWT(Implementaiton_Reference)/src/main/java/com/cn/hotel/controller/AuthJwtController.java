package com.cn.hotel.controller;

import com.cn.hotel.model.JwtRequest;
import com.cn.hotel.model.JwtResponse;
import com.cn.hotel.service.JwtAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthJwtController {
    @Autowired
    JwtAuthService jwtAuthService;
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) {
        return new ResponseEntity<>(jwtAuthService.login(jwtRequest), HttpStatus.OK);
    }
}
