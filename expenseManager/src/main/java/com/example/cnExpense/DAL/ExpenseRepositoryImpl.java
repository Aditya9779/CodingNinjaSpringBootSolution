package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository {
    @Autowired
    EntityManager entityManager;

    @Override
    public Income save(Expense expense, Integer incomeId) {
        Session session = entityManager.unwrap(Session.class);
        Integer expenseId = (Integer) session.save(expense);

        Income income = session.get(Income.class, incomeId);
        Expense savedExpense = session.get(Expense.class, expenseId);

        income.setExpense(savedExpense);
        expense.setIncome(income);

        session.save(income);
        session.save(savedExpense);

        return income;
//        return expense;
    }
}
