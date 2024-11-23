package com.example.cnExpense.controllers;

import com.example.cnExpense.entities.User;
import com.example.cnExpense.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET "/users/allUsers": Retrieve all users
    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET "/users/{id}": Fetch a user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    // POST "/users/save": Save a new user
    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // POST "/users/checkUserExist": Check if a user exists
    @PostMapping("/checkUserExist")
    public boolean checkUserExist(@RequestBody User user) {
        return userService.checkUserExist(user);
    }

    // POST "/users/find": Fetch the given user if found
    @PostMapping("/find")
    public User findUser(@RequestBody User newUser) {
        return userService.findUser(newUser);
    }

    // GET "/users/filteredUserListByCalendar": Fetch users by day, month, and year
    @GetMapping("/filteredUserListByCalendar")
    public List<User> getUsersByDateFilter(@RequestParam(value = "day", required = false) String day,
                                           @RequestParam(value = "month", required = false) String month,
                                           @RequestParam(value = "year", required = false) String year) {
        return userService.getUsersByDateFilter(day, month, year);
    }

    // GET "/users/filteredUserListByType": Fetch users by income type and expense type
    @GetMapping("/filteredUserListByType")
    public List<User> getUsersByTypeFilter(@RequestParam(value = "incomeType", required = false) String incomeType,
                                           @RequestParam(value = "expenseType", required = false) String expenseType) {
        return userService.getUsersByTypeFilter(incomeType, expenseType);
    }
}