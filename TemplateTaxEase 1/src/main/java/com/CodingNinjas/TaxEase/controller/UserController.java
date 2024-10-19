package com.CodingNinjas.TaxEase.controller;

import com.CodingNinjas.TaxEase.dto.UserDto;
import com.CodingNinjas.TaxEase.model.User;
import com.CodingNinjas.TaxEase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Add the annotation
@RestController
@RequestMapping("/user")
public class UserController {

    // Autowire userService@
    @Autowired
    UserService userService;

     @GetMapping("/all")
    public List<User> getAllUsers() {
        /**
         1. This method uses GET mapping with path: "/all"
         2. This API can only be accessed by the role 'ADMIN'
         3. It returns an OK HttpStatus
         4. It returns the list of all users.
         **/
        return userService.getAllUsers();
    }

    @GetMapping("/{userid}")
    public User getUserById(@PathVariable Long userid) {
        /**
         1. This method uses GET mapping with path: "/{userid}"
         2. This API can only be accessed by the role 'NORMAL'
         3. It returns an OK HttpStatus
         4. It returns user with given id.
         **/
        return userService.getUserById(userid);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody UserDto userDto) {
        /**
         1. This method uses POST mapping with path: "/signup"
         2. This API can be accessed by anyone
         3. It returns an CREATED HttpStatus
         4. It saves user into the database
         **/
        userService.createUser(userDto);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        /**
         1. This method uses PUT mapping with path: "/update/{id}"
         2. This API can only be accessed by the role 'NORMAL'
         3. It returns an CREATED HttpStatus
         4. It updates user into the database
         **/
        userService.updateUser(userDto, id);
    }

}
