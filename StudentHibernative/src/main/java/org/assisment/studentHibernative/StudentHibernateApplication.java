package org.assisment.studentHibernative;

import org.assisment.studentHibernative.Service.StudentService;
import org.assisment.studentHibernative.StudentEntity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Author(name = "Aditya Srivastava", date = "31-08-2024")
public class StudentHibernateApplication {
    /*Reference Image-https://drive.google.com/file/d/1gBBB81B34dWdRXqS5DUR1B9Njn6T_GQ7/view?usp=sharing*/
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StudentHibernateApplication.class, args);
        StudentService studentService = context.getBean(StudentService.class);
        Student student = new Student("Rahul", "College");
        studentService.saveDeatils(student);
    }
}
