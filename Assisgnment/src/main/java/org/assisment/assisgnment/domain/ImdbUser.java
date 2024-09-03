package org.assisment.assisgnment.domain;

import org.assisment.assisgnment.repository.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImdbUser implements User {
    String userName;
    String email;
    String password;
    @Autowired
    DAO<ImdbUser> dao;
    public Integer getUserId() {
        return userId;
    }

    Integer userId;
    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int saveUserDetails() {
        int imdbUserId= dao.saveDetails(this);
        System.out.println("new user added"+ this.userName+this.email+this.password+imdbUserId);
        return imdbUserId;
    }

    @Override
    public void setUserId(Integer userId) {
       this.userId = userId;
    }

    @Override
    public void createUser(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
