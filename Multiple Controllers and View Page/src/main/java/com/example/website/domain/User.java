package com.example.website.domain;

public interface User {
    public boolean createUser(String name, String college, String location, String gender);

    public int saveUser();
}
