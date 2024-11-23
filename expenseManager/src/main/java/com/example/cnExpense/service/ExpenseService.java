package com.example.cnExpense.service;

import com.example.cnExpense.DAL.ExpenseRepository;
import com.example.cnExpense.DAL.IncomeRepository;
import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private IncomeRepository incomeRepository;

    public Income saveExpense(Integer incomeId, Expense expense) {
//        Income income = incomeRepository.findById(incomeId);
//        if (income != null) {
//            expense.setIncome(income);
            return expenseRepository.save(expense, incomeId);
//        }
//        return null; // Handle income not found
//        throw new NotFoundException("not found");
    }
}