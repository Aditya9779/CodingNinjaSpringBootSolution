package org.assisment.airtelproblem.service;

import org.assisment.airtelproblem.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CorporateUserService implements UserService {

    @Autowired
    @Qualifier("cU")
    private User CorporativeUser;

    @Override
    public Boolean registeruser(String name, String plan, Integer number) {
        try {
            CorporativeUser.createUser(name, plan, number);
            return CorporativeUser.saveUserDetails();
        } catch (Exception e) {
            // Add appropriate error handling or logging
            return false;
        }
    }

    @Override
    public User getUserService() {
        return CorporativeUser;
    }
}
