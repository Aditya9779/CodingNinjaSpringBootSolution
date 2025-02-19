package Telecom.SubscriptionService.controller;

import Telecom.SubscriptionService.Exception.InternalServerError;
import Telecom.SubscriptionService.Exception.NotFoundException;
import Telecom.SubscriptionService.dto.ResponseMessage;
import Telecom.SubscriptionService.dto.UserDto;
import Telecom.SubscriptionService.model.User;
import Telecom.SubscriptionService.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable Long id) throws NotFoundException {
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseMessage createUser(@RequestBody UserDto userDto) throws InternalServerError {
        userService.createUser(userDto);
        return new ResponseMessage("User created Successfully");
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByName(@RequestParam String name) throws NotFoundException{
        return userService.getUserByName(name);
    }

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByEmail(@RequestParam String email) throws NotFoundException {
        return userService.getUserByEmail(email);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage updateUser(@PathVariable Long id, @RequestBody UserDto userDto) throws NotFoundException{
        userService.updateUser(id, userDto);
        return new ResponseMessage("User updated Successfully");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseMessage deleteUser(@PathVariable Long id) throws NotFoundException {
        userService.deleteUser(id);
        return new ResponseMessage("User Deleted Successfully");
    }

    @GetMapping("/tickets/{userId}")
    @ResponseStatus(HttpStatus.OK)
    @HystrixCommand(fallbackMethod = "getUserTicketsFallback")
    public List<Object> getUserTickets(@PathVariable Long userId) throws NotFoundException{
        return userService.getUserTickets(userId);
    }

    public List<Object> getUserTicketsFallback(@PathVariable Long userId) throws NotFoundException{
        return new ArrayList<>(Collections.singleton("Service not available"));
    }
}
