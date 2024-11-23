package com.example.cnExpense.DAL;

import com.example.cnExpense.entities.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<User> findAll() {
        Session session = entityManager.unwrap(Session.class);
        List<User> users = session.createQuery("from User ", User.class).getResultList();
        return users;
    }

    @Override
    public User findById(Integer id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class, id);
    }

    @Override
    public User save(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.save(user);
        return user;
    }

    @Override
    public boolean existsById(Integer id) {
        User user = findById(id);
        if (user == null) {
            return false;
        }
        return true;
    }

    @Override
    public List<User> getUsersByDateFilter(String day, String month, String year) {
        List<User> users = findAll();
        List<User> addUsers=new ArrayList<>();
        for (User user : users) {
            if(user.equals(day) && user.equals(month)&& user.equals(year)){
             addUsers.add(user);
            }
        }
        return addUsers;
    }

    @Override
    public List<User> getUsersByTypeFilter(String incomeType, String expenseType) {
        List<User> users = findAll();
        List<User> filter = new ArrayList<>();
        for (User user : users) {
            if (user.getIncomes().equals(incomeType) && user.equals(expenseType)) {
                filter.add(user);
            }
        }
        return filter;
    }

    @Override
    public User findByUserName(String username) {
        List<User> allUsers = findAll();

        for (User user : allUsers) {
            if (user.getUsername() != null && user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }

        return null;
    }
}
