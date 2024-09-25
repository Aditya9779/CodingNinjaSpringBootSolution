package com.example.todocrud.controller;

import com.example.todocrud.entity.Todo;
import com.example.todocrud.entity.Users;
import com.example.todocrud.services.TodoServices;
import com.example.todocrud.services.UserServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final TodoServices todoServices;
    private final UserServices userServices;

    public UserController(UserServices userServices,TodoServices todoServices){
        this.userServices = userServices;
        this.todoServices = todoServices;
    }

    @GetMapping("/{userId}")
    public Users getUserById(@PathVariable Long userId){
        return userServices.getUserById(userId);
    }

    @GetMapping("/todo/{todoId}")
    public Todo getTodoById(@PathVariable Long todoId){
        return todoServices.getTodoById(todoId);
    }

    @PostMapping
    public void addUser(@RequestBody Users userRequest){
        userServices.addUser(userRequest);
    }

    @PostMapping("/{userId}/todos")
    public void addTodo(@PathVariable Long userId, @RequestBody Todo todo){
        todoServices.addTodo(userId,todo);
    }

    @PostMapping("/todos/{todoId}")
    public void toggleTodoCompleted(@PathVariable Long todoId){
        todoServices.toggleTodoCompleted(todoId);
    }

    @PutMapping
    public void updateUser(@RequestBody Users user){
        userServices.updateUser(user);
    }

    @PutMapping("/todo")
    public void updateTodo(@RequestBody Todo todo){
        todoServices.updateTodo(todo);
    }


    @DeleteMapping("{userId}/todos/{todoId}")
    public void deleteTodo(@PathVariable Long userId,@PathVariable Long todoId){
        todoServices.deleteTodo(userId,todoId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userServices.deleteUser(userId);
    }
}
