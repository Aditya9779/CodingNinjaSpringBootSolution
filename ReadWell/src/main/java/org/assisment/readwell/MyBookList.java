package org.assisment.readwell;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MyBookList implements BookList {

    private ArrayList<Book> bookList;

    public MyBookList() {
        this.bookList = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        this.bookList.add(new MyBook("The Martian"));
        this.bookList.add(new MyBook("Sapiens"));
        this.bookList.add(new MyBook("Introduction to Algorithms"));
    }


    @Override
    public ArrayList<Book> getAllBooks() {
        return this.bookList;
    }

    @Override
    public void addBook(Book book) {
        this.bookList.add(book);
    }
}
