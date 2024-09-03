package org.assisment.readwell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("admin")
public class Admin implements User {
    private String name;

    @Autowired
    private BookList bookList;


    @Override
    public void setDetails(String details) {
        this.name = details;
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        return this.bookList.getAllBooks();
    }

    @Override
    public void issueOrAddBooks(Book book) {
        bookList.addBook(book);
    }
}
