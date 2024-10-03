package org.assisment.readwell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
@Author(name = "Aditya Srivastava",date = "12-08-2024")
public class ReadWellApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ReadWellApplication.class, args);
        System.out.println("Welcome to the Library Application");
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Please choose your user type \n1. Admin \n2. Student" +
                    "\n3. Exit ");
            int userType = scanner.nextInt();
            scanner.nextLine();
            String id = "";
            switch (userType) {
                case 1:
                    id = "admin";
                    break;
                case 2:
                    id = "student";
                    break;
                case 3:
                    flag = false;
                    System.out.println("Existing....");
                    return;
            }
            if (id.equals("admin")) {
                User user = context.getBean(Admin.class);
                System.out.println("Please enter your name:");
                String name = scanner.nextLine();
                boolean quit = true;
                while (quit) {
                    System.out.println("Do you want to add books \n1. Yes \n2. No");
                    int addBook = scanner.nextInt();
                    scanner.nextLine();
                    switch (addBook) {
                        case 1:
                            System.out.println("Enter the name of book");
                            String bookName = scanner.nextLine();
                            Book book = context.getBean(Book.class);
                            book.setBookname(bookName);
                            user.getAllBooks().add(book);
                            break;
                        case 2:
                            System.out.println("The List of books are:");
                            ArrayList<Book> bookList = user.getAllBooks();
                            for (int i = 0; i < bookList.size(); i++) {
                                if (!bookList.get(i).isIssued())
                                    System.out.println(bookList.get(i).getBookname() + " id:" + i);
                            }
                            quit = false;
                            break;
                    }
                }
            } else if (id.equals("student")) {
                User user = context.getBean(Students.class);
                System.out.println("Please enter your name:");
                String name = scanner.nextLine();
                user.setDetails(name);
                boolean quit = true;
                while (quit) {
                    System.out.println("The List of books are:");
                    ArrayList<Book> bookList = user.getAllBooks();
                    for (int i = 0; i < bookList.size(); i++) {
                        if (!bookList.get(i).isIssued())
                            System.out.println(bookList.get(i).getBookname() + " id:" + i);
                    }
                    System.out.println("Do you want to issue books: \n1. Yes \n2. No");
                    int issueBook = scanner.nextInt();
                    scanner.nextLine();
                    if (issueBook == 1) {
                        System.out.println("Enter the book number which you want to issue:");
                        int bookNumber = scanner.nextInt();
                        scanner.nextLine();
                        if (bookList.size() == 0 || bookNumber >= bookList.size() || bookNumber < 0) {
                            System.out.println("Invalid book number");
                        } else {
                            user.issueOrAddBooks(bookList.get(bookNumber));
                        }
                    } else if (issueBook == 2) {
                        quit = false;
                    }
                }
            }
        }
    }
}
