package com.Application.CodingNinjas;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Scope("prototype")
public class SimpleUserList implements UserList {
    ArrayList<User> user;

    public SimpleUserList() {
        this.user = new ArrayList<>();
    }

    public ArrayList<User> getUserList() {
        return this.user;
    }


    public void addUser(User userList) {
        this.user.add(userList);
    }
}
