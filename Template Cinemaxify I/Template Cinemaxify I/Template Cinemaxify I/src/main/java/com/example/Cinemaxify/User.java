package com.example.Cinemaxify;

public interface User {
    // This method sets the user's name, age, contact, and address based on the provided parameters
    void setUserDetails(String name, int age, Long contact, String address);

    //This method prints the user's details, including their name, member type,age, contact, and address
    void getUserDetails();
}
