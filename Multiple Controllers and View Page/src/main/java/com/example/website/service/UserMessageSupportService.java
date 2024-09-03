package com.example.website.service;

import com.example.website.domain.StudentUser;
import com.example.website.domain.UserMessageSupport;
import com.example.website.domain.userMessage;
import com.example.website.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserMessageSupportService implements UserSupport {

    @Autowired
    private UserMessageSupport userMessageSupport;
    @Autowired
    private StudentDao studentDao;

    @Override
    public String createUser(int id) {
        userMessageSupport.setUserid(id);
        userMessage support = (userMessage) userMessageSupport; //If we did't written the message
        // for in the (UserMessageSupport) interface so we do the type cast method to get the access
        //of the getter and setter method
        return support.getMessage();
    }

    public Optional<String> getUSerName(int id) {
        Optional<StudentUser> userOptional = studentDao.findById(id);
        if (userOptional.isPresent()) {
            return Optional.of(userOptional.get().getName());
        } else {
            return Optional.empty();
        }
    }
}
