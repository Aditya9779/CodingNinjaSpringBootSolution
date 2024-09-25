package com.example.todocrud.repository;

import com.example.todocrud.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Long> {
}
