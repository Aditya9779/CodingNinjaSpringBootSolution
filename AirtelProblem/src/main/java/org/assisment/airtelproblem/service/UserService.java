package org.assisment.airtelproblem.service;

import org.assisment.airtelproblem.domain.User;

public interface UserService {
    public Boolean registeruser(String name, String plan, Integer number);

    public User getUserService();
}
