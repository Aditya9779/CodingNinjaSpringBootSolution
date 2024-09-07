package com.example.Cinemaxify;

// Override the User Interface methods in Spouse class
public class Spouse implements User {
    private String name;
    private String memberName = "spouse";
    private int age;
    private Long contact;
    private String address;

    @Override
    public void setUserDetails(String name, int age, Long contact, String address) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.address = address;
    }

    @Override
    public void getUserDetails() {
        System.out.println("Hello " + this.name + " you have entered the following details for " + this.memberName +
                "\nage: " + this.age + "\ncontact: " + this.contact + "\naddress: " + this.address
        );
    }
}
