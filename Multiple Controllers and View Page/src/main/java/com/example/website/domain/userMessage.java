package com.example.website.domain;

import com.example.website.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class userMessage implements UserMessageSupport {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;

    @Override
    public void setUserid(int userid) {
   this.message="Hi Welcome to support Page (Domain) " + String.valueOf(userid);
    }

}
