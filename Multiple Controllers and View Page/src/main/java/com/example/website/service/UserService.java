package com.example.website.service;

import com.example.website.domain.User;

public interface UserService {
    public User getUser ();
    public int signUp(String name, String college, String location, String gender);

}
