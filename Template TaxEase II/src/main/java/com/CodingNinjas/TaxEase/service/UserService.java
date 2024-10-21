package com.CodingNinjas.TaxEase.service;

import com.CodingNinjas.TaxEase.dto.UserDto;
import com.CodingNinjas.TaxEase.exception.UserNotFoundException;
import com.CodingNinjas.TaxEase.model.Role;
import com.CodingNinjas.TaxEase.model.User;
import com.CodingNinjas.TaxEase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
	@Autowired
 	UserRepository userRepository;

	public void createUser(UserDto userDto) {
		BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
		String encodedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());
		Role role = new Role();
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(encodedPassword);
		user.setAge(userDto.getAge());
		if(userDto.getRole().contains("NORMAL")){
			role.setRoleName("ROLE_NORMAL");
		} else if (userDto.getRole().contains("ADMIN")){
			role.setRoleName("ROLE_ADMIN");
		} else{
			role.setRoleName("ROLE_NORMAL");
		}
		Set<Role> rolesSet = new HashSet<>();
		rolesSet.add(role);
		user.setRoles(rolesSet);
		userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void updateUser(UserDto userDto, Long id) {
		if(userRepository.existsById(id)){
			BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
			String encodedPassword = bCryptPasswordEncoder.encode(userDto.getPassword());
			User user = new User();
			user.setId(id);
			user.setUsername(userDto.getUsername());
			user.setPassword(encodedPassword);
			user.setAge(userDto.getAge());
			userRepository.save(user);
		}
	}

	public User getUserById(Long userid) {
		return userRepository.findById(userid).
				orElseThrow(()-> new UserNotFoundException("User not found for id: " + userid));
	}
}
