package com.cn.hotel.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cn.hotel.dto.UserRequest;
import com.cn.hotel.model.User;
import com.cn.hotel.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void createUser(UserRequest userRequest) {
		BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
		String encodedPassword = bCryptPasswordEncoder.encode(userRequest.getPassword());
		
		User user = new User();
		user.setUsername(userRequest.getUsername());
		user.setPassword(encodedPassword);
		userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
