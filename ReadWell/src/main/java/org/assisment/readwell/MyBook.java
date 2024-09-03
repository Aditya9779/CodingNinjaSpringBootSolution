package org.assisment.readwell;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myBook")
@Scope("prototype")
public class MyBook implements Book {
    private String name;
    private boolean isIssued = false;

    public MyBook() {
    }
    public MyBook(String name) {
        this.name = name;
    }

    @Override
    public String getBookname() {
        return this.name;
    }

    @Override
    public void setBookname(String bookname) {
        this.name = bookname;

    }

    @Override
    public boolean isIssued() {
        return this.isIssued;
    }

    @Override
    public void issue() {
        this.isIssued = true;
    }
}
