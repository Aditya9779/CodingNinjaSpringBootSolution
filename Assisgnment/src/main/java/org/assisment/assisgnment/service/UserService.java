package org.assisment.assisgnment.service;

import org.assisment.assisgnment.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements ServiceLayer {
    @Autowired
    User user;

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public int RegisterUser(String userName, String email, String password) {
        user.createUser(userName, email, password);
        return user.saveUserDetails();
    }
}
