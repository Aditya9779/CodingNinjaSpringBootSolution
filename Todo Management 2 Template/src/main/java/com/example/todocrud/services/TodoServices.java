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

  /*  public void deleteTodo(Long userId, Long todoId) {
        Users user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            List<Todo> todos = user.getTodoList();

            if (todos != null) {
                for (int i = 0; i < todos.size(); i++) {
                    if (todos.get(i).getId()==todoId) {
                        todos.remove(i); // Remove the Todo by ID
                        break; // Exit the loop after removing
                    }
                }
                userRepository.save(user); // Save the updated user
            }
        }
    }
*/ public void deleteTodo(Long userId,Long todoId){
      Todo removedTodo = new Todo();
      Users user = userServices.getUserById(userId);
      Todo todo = this.getTodoById(todoId);
      for(int i = 0 ; i < user.getTodoList().size() ; i++){
          if(user.getTodoList().get(i).getId() == todo.getId()){
              removedTodo  = user.getTodoList().remove(i);
          }
      }
      System.out.println("removed todo -> " + removedTodo.getId() + " | " + removedTodo.getContent());
      userRepository.save(user);
      toDoRepository.deleteById(todoId);
  }


    public void toggleTodoCompleted(Long todoId) {
        Todo todo = this.getTodoById(todoId);
        todo.setCompleted(!todo.getCompleted());
        toDoRepository.save(todo);
    }

    public void updateTodo(Todo todo) {
        List<Users> users = new ArrayList<>();
        int count = 0;
        for (Users users1 : userRepository.findAll()) {
            users.add(users1);
        }
        for (Users users1 : users) {
            List<Todo> todos = users1.getTodoList();
            count = 0;
            for (Todo x : todos) {
                if (x.getId() == todo.getId()) {
                    todos.add(count, todo);
                    userRepository.save(users1);
                    break;
                }
                count++;
            }
        }
    }

}
