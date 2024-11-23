package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.Income;
import com.example.cnExpense.entities.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class IncomeRepositoryImpl implements IncomeRepository{
    @Autowired
    EntityManager entitymanager;
    @Override
    public Income findById(Integer incomeId) {
        Session session=entitymanager.unwrap(Session.class);
        Income income=session.find(Income.class,incomeId);
        return income;
    }

    @Override
    public Income save(Income income, Integer userId) {
        Session session=entitymanager.unwrap(Session.class);
        Integer incomeId = (Integer) session.save(income);

        User user = session.get(User.class, userId);
        Income savedIncome = session.get(Income.class, incomeId);

        user.getIncomes().add(savedIncome);
        savedIncome.getUsers().add(user);
        session.save(user);
        session.save(income);

        return savedIncome;
    }
}
