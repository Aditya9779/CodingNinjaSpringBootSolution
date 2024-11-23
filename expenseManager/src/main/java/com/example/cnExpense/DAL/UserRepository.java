package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User findById(Integer id);

    User save(User user);

    boolean existsById(Integer id);

    List<User> getUsersByDateFilter(String day, String month, String year);

    List<User> getUsersByTypeFilter(String incomeType, String expenseType);

    User findByUserName(String username);
}
