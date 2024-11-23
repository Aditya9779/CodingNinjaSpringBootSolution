package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.Income;

public interface IncomeRepository {
    Income findById(Integer incomeId);

    Income save(Income income, Integer userId);
}
