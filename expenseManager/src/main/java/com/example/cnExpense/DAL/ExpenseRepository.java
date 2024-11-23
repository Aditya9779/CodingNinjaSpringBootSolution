package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;

public interface ExpenseRepository {
    Income save(Expense expense, Integer incomeId);
}
