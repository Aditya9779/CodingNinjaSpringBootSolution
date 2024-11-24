package com.devtools.solution.service;

import com.devtools.solution.DTO.BookDto;
import com.devtools.solution.entity.Book;
import com.devtools.solution.repo.BookDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookDal bookDal;

    // Retrieve book by ID
    public Book getBookById(int id) {
        return  bookDal.findById(id).get();

    }

    // Save a new book
    public Book saveBook(BookDto bookDto) {
        Book book = convertToEntity(bookDto);
        return bookDal.save(book);
    }

    // Delete a book by ID
    public void deleteBookById(int id) {
        bookDal.deleteById(id);
    }

    // Retrieve all books
    public List<Book> getAllBooks() {
        List<Book> books = bookDal.findAll();
        return books;
    }

    // Convert Book entity to BookDto
    private BookDto convertToDto(Book book) {
        return new BookDto(book.getTitle(), book.getAuthor(), book.getPrice(), book.getQuantity());
    }

    // Convert BookDto to Book entity
    private Book convertToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPrice(bookDto.getPrice());
        book.setQuantity(bookDto.getQuantity());
        return book;
    }
}
