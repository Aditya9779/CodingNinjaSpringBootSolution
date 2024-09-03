package com.PostApplication.SocialMedia;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class SocialMediaApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        PostList postList = context.getBean("simplePostList", PostList.class);
        System.out.println("Welcome to Social Media Application");
        Scanner scanner = new Scanner(System.in);
        boolean quit = true;
        User currentUser = context.getBean("customer", User.class);
        System.out.println("Please enter your name: ");
        String userName = scanner.nextLine();
        currentUser.setName(userName);
        while (quit) {
            System.out.print("1) Make New Post \n2) Show All Posts \n3) Exit \n");
            int choice = scanner.nextInt();
            PostList postList = currentUser.getPostList();
            switch (choice) {
                case 1:
                    Post post = context.getBean("simplePost", Post.class);
                    System.out.println("Make New Post");
                    scanner.nextLine();
                    String newPost = scanner.nextLine();
                    post.setMessage(newPost);
                    postList.setPosts(post);
                    break;
                case 2:
                    System.out.println("All the Posts are!");
                    for (int i = 0; i < postList.size(); i++) {
                        System.out.println(i + " " + currentUser.getName() + "- ( " + postList.getPosts(i).getMessage() + " )");
                    }
                    break;
                case 3:
                    quit = false;
                    break;
            }
        }

        scanner.close();
        context.close(); /*This have done for destroying the post*/
    }

}
