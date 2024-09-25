package com.example.todocrud.repository;

import com.example.todocrud.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<Todo,Long> {
}
