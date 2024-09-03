package com.Application.CodingNinjas;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component("javaInstructor")
public class JavaInstructor implements Instructor {
    private String name;
    private int age;

    @PostConstruct
    public void inti() {
        System.out.println("Hello its the inti method in Java Instructor");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Hello its the destroy method in Java Instructor");
    }


    @Override
    public void setInstructorDeatils(String instructorName, int age) {
        this.name = instructorName;
        this.age = age;
    }

    @Override
    public String takeClass() {
        return "Hi my name is "+this.name+" and I will be your Java"
                + "instructor";
    }
}
