package org.assisment.assisgnment.service;

import org.assisment.assisgnment.domain.User;

public interface ServiceLayer {
    public User getUser();

    public int RegisterUser(String userName, String email, String password);

}

