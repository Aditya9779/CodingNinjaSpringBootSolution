package com.example.todocrud.services;

import com.example.todocrud.entity.Todo;
import com.example.todocrud.entity.Users;
import com.example.todocrud.repository.ToDoRepository;
import com.example.todocrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServices {

    @Autowired
    UserServices userServices;
    @Autowired
    ToDoRepository toDoRepository;
    @Autowired
    UserRepository userRepository;

    public Todo getTodoById(Long todoId) {

        return toDoRepository.findById(todoId).get();
    }

    public void addTodo(Long userId, Todo todo) {
        Optional<Users> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            List<Todo> todos = user.getTodoList();
            if (todos == null) {
                todos = new ArrayList<>();
            }
            todos.add(todo);
            user.setTodoList(todos);
            userRepository.save(user);
        }
    }

    public void deleteTodo(Long userId, Long todoId) {

    }

    public void toggleTodoCompleted(Long todoId) {
        Todo todo = this.getTodoById(todoId);
        todo.setCompleted(!todo.getCompleted());
        toDoRepository.save(todo);
    }

    public void updateTodo(Todo todo) {

    }

}
