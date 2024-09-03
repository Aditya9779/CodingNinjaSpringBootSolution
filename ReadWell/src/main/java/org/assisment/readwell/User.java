package org.assisment.readwell;

import java.util.ArrayList;

public interface User {
    public void setDetails(String details);
    public ArrayList<Book> getAllBooks();
    public void issueOrAddBooks(Book book);
}
