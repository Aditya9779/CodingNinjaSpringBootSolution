package com.cn.hotel.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.cn.hotel.dto.JwtRequest;
import com.cn.hotel.dto.JwtResponse;
import com.cn.hotel.jwt.JwtAuthenticationHelper;

public class AuthServiceTest {
	@Mock
	private AuthenticationManager authenticationManager;
	
	@Mock
	private JwtAuthenticationHelper jwtAuthenticationHelper;
	
	@Mock
	private UserDetailsService userDetailsService;
	
	@InjectMocks
	private AuthService authService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void shouldTestForValidLogin() {
		JwtRequest jwtRequest = new JwtRequest("username", "password");
		UserDetails userDetails = Mockito.mock(UserDetails.class);
		String token = "testToken";
		
		when(userDetailsService.loadUserByUsername(jwtRequest.getUsername())).thenReturn(userDetails);
		when(jwtAuthenticationHelper.generateToken(userDetails)).thenReturn(token);
		
		JwtResponse jwtResponse = authService.login(jwtRequest);
		
		assertNotNull(jwtResponse);
		assertEquals(token, jwtResponse.getJwtToken());
	}
	
	@Test
	public void shouldTestForInvalidLogin() {
		JwtRequest jwtRequest = new JwtRequest("username", "password");
		UserDetails userDetails = Mockito.mock(UserDetails.class);
		String token = "testToken";
		
		when(userDetailsService.loadUserByUsername(jwtRequest.getUsername())).thenReturn(userDetails);
		when(authenticationManager.authenticate(Mockito.any(UsernamePasswordAuthenticationToken.class)))
					.thenThrow(new BadCredentialsException("Invalid Username or Password"));
		
		assertThrows(BadCredentialsException.class, () -> authService.login(jwtRequest));
	}
}
