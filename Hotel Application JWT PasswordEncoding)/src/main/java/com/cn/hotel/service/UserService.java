package com.cn.hotel.service;

import com.cn.hotel.dto.UserRequest;
import com.cn.hotel.model.User;
import com.cn.hotel.repository.UserRepository;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserRequest userRequest) {
        //BCryptPasswordEncoder This is One hashing algorithms
//		BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userRequest.getPassword());

        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
