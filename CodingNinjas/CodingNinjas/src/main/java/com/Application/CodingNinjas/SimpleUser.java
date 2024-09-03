package com.Application.CodingNinjas;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component  //This is known as notations say for the java
@Scope("prototype")
public class SimpleUser implements User {
    private String name;
    private int age;
    private String locaion;
    public String collegeName;

    @Override
    public String getUserDetails() {
        return this.name + " age:" + this.age;
    }

    @Override
    public void setUserDetails(String name, int age, String locaion, String collegeName) {
        this.name = name;
        this.age = age;
        this.locaion = locaion;
        this.collegeName = collegeName;
    }
}
