package com.Application.CodingNinjas;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component("springInstructor")
public class SpringInstructor implements Instructor {
    private String name;
    private int age;

    @Override
    public void setInstructorDeatils(String instructorName, int age) {
        this.name = instructorName;
        this.age = age;
    }

    @Override
    public String takeClass() {
        return "Hi my name is " + this.name + " and I will be your Spring"
                + "instructor";
    }

    @PostConstruct
    public void init() {
        System.out.println("Hello, this is the init method in SpringInstructor.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Hello, this is the destroy method in SpringInstructor.");
    }
}
