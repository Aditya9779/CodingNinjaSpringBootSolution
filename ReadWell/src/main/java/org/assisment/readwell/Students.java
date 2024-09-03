package org.assisment.readwell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("students")
public class Students implements User {
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
    public void issueOrAddBooks(Book mybook) {
        for (Book book : this.bookList.getAllBooks()) {
            if (book.getBookname().equals(mybook.getBookname()) && book.isIssued() == false) {
                System.out.println("Book: " + book.getBookname() + " is issued to " + this.name);
                book.issue();
                break;
            }
        }

    }
}
