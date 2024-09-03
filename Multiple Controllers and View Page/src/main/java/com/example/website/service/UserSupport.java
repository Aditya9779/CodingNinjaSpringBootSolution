package com.example.website.service;

import java.util.Optional;

public interface UserSupport {
    public String createUser(int id);

    public Optional<String> getUSerName(int id);

}
