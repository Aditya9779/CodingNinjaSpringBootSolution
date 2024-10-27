package com.CN.PharmaLink.controller;

import com.CN.PharmaLink.dto.MedicalStoreDto;
import com.CN.PharmaLink.dto.UserRequest;
import com.CN.PharmaLink.model.User;
import com.CN.PharmaLink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public void registerUser(@RequestBody UserRequest userRequest) {
		userService.createUser(userRequest);
	}
	@GetMapping("/getNearestStores/{userId}/{distance}/{token}")
	public List<MedicalStoreDto> getNearestStores(@PathVariable Long userId, @PathVariable Long distance, @PathVariable String token) {
		return userService.getNearestMedicalStores(userId, distance, token);
	}

	@GetMapping("/getStoresWithMedicine/{medicine}/{token}")
	public List<MedicalStoreDto	> getStoresWithMedicine(@PathVariable String medicine, @PathVariable String token) {
		return userService.getMedicalStoresWithMedicine(medicine, token);
	}

}
