package com.CodingNinjas.TaxEase.controller;

import com.CodingNinjas.TaxEase.dto.UserDto;
import com.CodingNinjas.TaxEase.model.User;
import com.CodingNinjas.TaxEase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{userid}")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('NORMAL')")
	public User getUserById(@PathVariable Long userid) {
		return userService.getUserById(userid);
	}

	@PostMapping("/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public void addUser(@RequestBody UserDto userDto) {
		userService.createUser(userDto);
	}

	@PutMapping("/update/{id}")
	@PreAuthorize("hasRole('NORMAL')")
	@ResponseStatus(HttpStatus.CREATED)
	public void updateUser(@PathVariable Long id,@RequestBody UserDto userDto) {
		userService.updateUser(userDto,id);
	}

}
