package com.Application.CodingNinjas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication  //---this is calling we dont have to create by itself spring create
public class CodingNinjasApplication {

    public static void main(String[] args) {

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /*In spring we do not have to call by itself spring create /
//    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.Application.CodingNinjas");

         /*Creatin by its self ---see upside*/
        ApplicationContext context = SpringApplication.run(CodingNinjasApplication.class, args);

        System.out.println("Welcome to the coding ninjas application");
        ArrayList<PaidCourse> paidCourse = new ArrayList<PaidCourse>();
        Scanner scanner = new Scanner(System.in);
        /*PaidCourse javaCourse = context.getBean("paidCouserJava", PaidCourse.class);
        PaidCourse springCourse = context.getBean("paidCouserSpring", PaidCourse.class);*/
        PaidCourse courseTypeJava = context.getBean(PaidCourse.class);
        courseTypeJava.setInstructor("java");
        courseTypeJava.getInstructor().setInstructorDeatils("Rohan Sigh", 23);
        courseTypeJava.setCourseDeatil("Basic Of Java");
        paidCourse.add(courseTypeJava);
        PaidCourse courseTypeSpring = context.getBean(PaidCourse.class);
        courseTypeSpring.setInstructor("spring");
        courseTypeSpring.getInstructor().setInstructorDeatils("Rahul Mohan", 24);
        courseTypeSpring.setCourseDeatil("Basic Of Spring");
        paidCourse.add(courseTypeSpring);

        /*javaCourse.getInstructor().setInstructorDeatils("Rohan Sigh", 23);
        javaCourse.setCourseDeatil("Basic Of Java");

        springCourse.getInstructor().setInstructorDeatils("Rahul Mohan", 24);
        springCourse.setCourseDeatil("Basic Of Spring");

        paidCourse.add(javaCourse);
        paidCourse.add(springCourse);*/

        boolean quit = true;

        while (quit) {
            System.out.println("-----XXXXXX-----");
            System.out.println("Please select from the following:");
            System.out.println("1) Register a new user");
            System.out.println("2) See course information");
            System.out.println("3) To quit");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    User user = context.getBean(User.class);
                    System.out.println("Please enter your name");
                    String name = scanner.nextLine();
                    System.out.println("Please enter your age");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter your College");
                    String college = scanner.nextLine();
                    System.out.println("Please enter your location");
                    String location = scanner.nextLine();
                    user.setUserDetails(name, age, location, college);
                    int index = 0;
                    System.out.println("Please select a course");
                    for (Course course : paidCourse) {
                        System.out.println(index + ")" + course.getCourseName());
                        index++;
                    }
                    //Taking the course id which is coming in the paidcouse arraylist
                    int courseId = scanner.nextInt();
                    scanner.nextLine();  // Consume the leftover newline
                    if (courseId >= paidCourse.size()) {
                        System.out.println("Not a valid course");
                        break;
                    }
                    PaidCourse selectedCourse = paidCourse.get(courseId); //Adding in the array
                    // which we created in the upper
                    selectedCourse.userList.addUser(user);
                    break;
                case 2:
                    for (Course course : paidCourse) {
                        System.out.println("-----XXXXXX-----");
                        System.out.println(course.getCourseName());
                        //get user list do baar ka matlab hai ki ek for loop wala course
                        //jo har course ka andar ja raha hai aur uska course ka size kya hai
                        if (course.getUsersListsEnrolledCourse().getUserList().size() > 0) {
                            System.out.println("The students in the course:");
                            int count = 1;
                            // display all the students who have enrolled.
                            for (User userA : course.getUsersListsEnrolledCourse().getUserList()) {
                                System.out.println(count + ") " + userA.getUserDetails());
                                count++;
                            }

                        } else {
                            System.out.println("No students registerd for the course");
                        }
                    }
                    break;
                case 3:
                    quit = false;
                    break;
            }
        }
        scanner.close();
        /* context.close();   This method is create by its self so we do not create and stop*/

    }

}
//Creating with the anotations

/*
    This use for understand the how the anotations work in the spring boot lets
    move to our original code and remove the xml file and try using the anotations

/*IOC*//*

        //Taking the input from the notation
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.Application.CodingNinjas");
        Scanner scanner = new Scanner(System.in);
        User user = context.getBean(User.class);
        System.out.println("Please enter your name");
        String name = scanner.nextLine();
        System.out.println("Please enter your age");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter your College");
        String college = scanner.nextLine();
        System.out.println("Please enter your location");
        String location = scanner.nextLine();
        user.setUserDetails(name, age, location, college);


        */
/*Testing DI*//*

 */
/* Instructor javaInstructor = context.getBean(JavaInstructor.class);
        javaInstructor.setInstructorDeatils("Rohan Singh", 26);
        System.out.println(javaInstructor.takeClass());

        //This is for java

        PaidCourse paidCourse = context.getBean(PaidCourse.class);
        paidCourse.setCourseDeatil("Hello this is java Course");
        System.out.println(paidCourse.getCourseName());*//*



 */
/**************************************************************************//*


 */
/*For spring we have to change the qualifier name in paidcourse id*//*

 */
/*    Instructor springInstructor = context.getBean(SpringInstructor.class);
        springInstructor.setInstructorDeatils("Aditya",22);
        System.out.println(springInstructor.takeClass());

        PaidCourse paidCourse = context.getBean(PaidCourse.class);
        paidCourse.setCourseDeatil("Hello this is spring class");
        System.out.println(paidCourse.getCourseName());*//*



        PaidCourse paidCourse = context.getBean(PaidCourse.class);
        paidCourse.setCourseDeatil("This is your test course Spring");
        paidCourse.setInstructor("spring");
        System.out.println(paidCourse.getCourseName());
        paidCourse.getInstructor().setInstructorDeatils("Rahul", 23);
        System.out.println(paidCourse.getInstructor().takeClass());


        paidCourse.setCourseDeatil("This is your test course Java");
        paidCourse.setInstructor("java");
        System.out.println(paidCourse.getCourseName());
        paidCourse.getInstructor().setInstructorDeatils("Rohan", 23);
        System.out.println(paidCourse.getInstructor().takeClass());
*/


