package com.CN.PharmaLink.service;

import com.CN.PharmaLink.communicator.StoreFinderCommunicator;
import com.CN.PharmaLink.dto.MedicalStoreDto;
import com.CN.PharmaLink.dto.UserRequest;
import com.CN.PharmaLink.model.Role;
import com.CN.PharmaLink.model.User;
import com.CN.PharmaLink.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void createUser(UserRequest userRequest) {
		String encodedPassword = passwordEncoder.encode(userRequest.getPassword());
		User user = new User();
		user.setUsername(userRequest.getUsername());
		user.setPassword(encodedPassword);
		Role role = new Role();
		role.setRoleName("ROLE_ADMIN");
		Set<Role> roleSet = new HashSet<>();
		roleSet.add(role);
		user.setRoles(roleSet);
		user.setYCoordinate(userRequest.getYcoordinate());
		user.setXCoordinate(userRequest.getXcoordinate());
		userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	@Autowired
	private StoreFinderCommunicator storeFinderCommunicator;

	public List<MedicalStoreDto> getNearestMedicalStores(Long userId, Long distance, String token) {
		return storeFinderCommunicator.getNearestMedicalStores(userId, distance, token);
	}

	public List<MedicalStoreDto> getMedicalStoresWithMedicine(String medicine, String token) {
		return storeFinderCommunicator.getMedicalStoresWithMedicine(medicine, token);
	}

}
