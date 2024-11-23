package com.example.cnExpense.service;


import com.example.cnExpense.DAL.UserRepository;
import com.example.cnExpense.entities.User;
import com.example.cnExpense.exception.ElementAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public boolean checkUserExist(User user) {
        return userRepository.existsById(user.getId());
    }

    // in this method, you need for filter the user using username
    public User findUser(User newUser) {
//       User user=getUserById(newUser.getId());
//       if(user!=null){
//         throw new  ElementAlreadyExistException("Already Present");
//       }
//       return userRepository.findById(newUser.getId());
        return userRepository.findByUserName(newUser.getUsername());
    }

    public List<User> getUsersByDateFilter(String day, String month, String year) {

        return userRepository.getUsersByDateFilter(day,month,year);
    }

    public List<User> getUsersByTypeFilter(String incomeType, String expenseType) {
        // Add logic to filter users based on IncomeType and ExpenseType
        return userRepository.getUsersByTypeFilter(incomeType,expenseType);
    }
}
