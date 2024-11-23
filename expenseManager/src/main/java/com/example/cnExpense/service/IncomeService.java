package com.example.cnExpense.service;


import com.example.cnExpense.DAL.IncomeRepository;
import com.example.cnExpense.DAL.UserRepository;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.User;
import com.example.cnExpense.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private UserRepository userRepository;

    public Income getIncomeById(Integer incomeId) {
        Income income = incomeRepository.findById(incomeId);
        if (income == null) {
            throw new NotFoundException("Not found");
        }
        return income;
    }

    public Income saveIncome(Integer userId, Income income) {
//        User user = userRepository.findById(userId);
//        if (user != null) {
//            income.getUsers().add(user);
            return incomeRepository.save(income, userId);
//        }
//        throw new NotFoundException("Not Found");
    }
}
