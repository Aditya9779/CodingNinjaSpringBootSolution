package org.assisment.airtelproblem.service;

import org.assisment.airtelproblem.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NormalUserService implements UserService {
    @Autowired
            @Qualifier("nU")
    User user;

    @Override
    public Boolean registeruser(String name, String plan, Integer number) {
        user.createUser(name, plan, number);
        return user.saveUserDetails();
    }

    @Override
    public User getUserService() {
        return user;
    }
}
