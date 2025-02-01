package com.cn.hotel.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.validator.PublicClassValidator;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cn.hotel.dto.UserRequest;
import com.cn.hotel.model.User;
import com.cn.hotel.repository.UserRepository;

public class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private  UserService userService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void shouldTestGetAllUsers() {
		List<User> userList = new ArrayList<>();
		userList.add(new User());
		
		Mockito.when(userRepository.findAll()).thenReturn(userList);
		
		List<User> resultList = userService.getAllUsers();
		Assertions.assertEquals(userList.size(), resultList.size());
	}
	
	@Test
	public void shouldTestCreateUser() {
		UserRequest userRequest = new UserRequest();
		userRequest.setUsername("testUser");
		userRequest.setPassword("testPassword");
		
		BCryptPasswordEncoder bCryptPasswordEncoder = mock(BCryptPasswordEncoder.class);
		when(bCryptPasswordEncoder.encode(userRequest.getPassword())).thenReturn("encodedPassword");
		
		User expectedUser = new User();
		expectedUser.setUsername("testUser");
		expectedUser.setPassword("encodedPassword");
		
		when(userRepository.save(any(User.class))).thenReturn(expectedUser);
		
		userService.createUser(userRequest);
		verify(userRepository).save(any(User.class));
		
	}
		
}
