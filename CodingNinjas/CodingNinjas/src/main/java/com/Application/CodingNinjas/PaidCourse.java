package com.Application.CodingNinjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PaidCourse implements Course {
    @Autowired
    UserList userList;
    // @Autowired
    // @Qualifier("javaInstructor")  //This is for mention if interface has two or more thatone class
    //@Qualifier("springInstructor")  //This is for mention if interface has two or more thatone class
    /*This task i have to do in runtime so we have to apply the scope ==prototype*/
    private Instructor courseInstructor;
    private String courseName;

    @Autowired
    @Qualifier("javaInstructor")
    private Instructor javaInstructor;
    @Autowired
    @Qualifier("springInstructor")
    private Instructor springInstructor;

    //Using with help of anotations
   /* public PaidCourse(Instructor instructor,UserList userList) {
        this.courseInstructor = instructor;
        this.userList = userList;
    }*/
    @Override
    public void setCourseDeatil(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public UserList getUsersListsEnrolledCourse() {
        return this.userList;
    }

    @Override
    public Instructor getInstructor() {
        return this.courseInstructor;
    }

    public void setInstructor(String instructorType) {
        if (instructorType.equals("java")) {
            this.courseInstructor = this.javaInstructor;
        } else if (instructorType.equals("spring")) {
            this.courseInstructor = this.springInstructor;
        }
    }

    @Override
    public String getCourseName() {
        return this.courseName;
    }
}
