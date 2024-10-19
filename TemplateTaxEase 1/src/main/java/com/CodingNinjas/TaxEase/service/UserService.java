package com.CodingNinjas.TaxEase.service;

import com.CodingNinjas.TaxEase.dto.UserDto;
import com.CodingNinjas.TaxEase.exception.UserNotFoundException;
import com.CodingNinjas.TaxEase.model.Role;
import com.CodingNinjas.TaxEase.model.User;
import com.CodingNinjas.TaxEase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // Autowire UserRepository
    @Autowired
    UserRepository userRepository;

    public void createUser(UserDto userDto) {
        /**
         1. It saves a user into the database using UserRepository
         2. If userDto role field is empty then by default `NORMAL`
         user role should be assigned.
         **/
        User user = new User();
        user.setAge(userDto.getAge());
        user.setPassword(userDto.getPassword());
        Role role = new Role();
        if (userDto.getRole().isEmpty()) {
            role.setRoleName("NORMAL");
            user.getRoles().add(role);
        } else {
            role.setRoleName(userDto.getRole());
            user.getRoles().add(role);
        }
        user.setUsername(userDto.getUsername());
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        /** 1. It returns the list of all users present in the database. **/
        return userRepository.findAll();
    }

    public void updateUser(UserDto userDto, Long id) {
        /**
         1. This method initially checks if user by given id exists in the database or not.
         2. If user is found then it is updated using UserRepository.
         3. Only the role field of the user cannot be updated from this method.
         **/
        User user = getUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User Not Found");
        }
//        Role role = new Role();
//        role.setRoleName(userDto.getUsername());
//        user.getRoles().add(role);
//        User user = new User();
        user.setAge(userDto.getAge());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        userRepository.save(user);
    }

    public User getUserById(Long userid) {
        /**
         1. This method finds the user using UserRepository in the database.
         2. If user is found then it simply returns it.
         3. If the user is not found then an exception of type `UserNotFoundException`
         with custom message is thrown.
         **/
        User user = userRepository.findById(userid).orElseThrow(() -> {
            throw new UserNotFoundException("Not FOund");
        });
        return user;
    }
}
