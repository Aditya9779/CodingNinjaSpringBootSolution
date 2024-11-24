package com.devtools.solution.service;

import com.devtools.solution.entity.User;
import com.devtools.solution.repo.UserRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepoInterface userRepo;

    // Retrieve user by ID
    public User getUserById(int id) {
        Optional<User> userOptional = userRepo.findById(id);
        return userOptional.orElse(null);
    }

    // Save a new user
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    // Delete a user by ID
    public void deleteUserById(int id) {
        userRepo.deleteById(id);
    }
}
