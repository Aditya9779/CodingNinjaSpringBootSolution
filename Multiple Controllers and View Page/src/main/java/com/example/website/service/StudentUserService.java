package com.example.website.service;

import com.example.website.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentUserService implements UserService {

    @Autowired //This is dependency injection
    User studentUser;


    @Override
    public User getUser() {
        return this.studentUser;
    }

    @Override
    public boolean signUp(String name, String college, String location, String gender) {
        boolean isCreated = studentUser.createUser(name, college, location, gender);
        studentUser.saveUser();
        return isCreated;
    }
}
