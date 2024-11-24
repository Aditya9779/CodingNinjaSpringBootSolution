package com.devtools.solution.controller;

import com.devtools.solution.DTO.BookDto;
import com.devtools.solution.entity.Book;
import com.devtools.solution.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    // Get book details by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
       return ResponseEntity.ok(bookService.getBookById(id));
    }

    // Save a new book
    @PostMapping("/save")
    public ResponseEntity<Book> saveBook(@RequestBody BookDto bookDto) {
        Book savedBook = bookService.saveBook(bookDto);
        return ResponseEntity.ok(savedBook);
    }

    // Delete a book by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBookById(@PathVariable int id) {
        bookService.deleteBookById(id);
    }

    // Get all books
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        return ResponseEntity.ok(bookList);
    }
}
