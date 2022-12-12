package com.jatin.springbootservcie.controller;

import com.jatin.springbootservcie.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jatin.springbootservcie.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //save the book
    @PostMapping("/save")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        System.out.println("Saving...");
        return new ResponseEntity<>(bookService.saveBookDetails(book), HttpStatus.CREATED);
    }

    //fetch
    @GetMapping("/fetch")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.fetachAllDetails(), HttpStatus.OK);
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") Integer id) {
        return new ResponseEntity<>(bookService.updateBookDetails(book, id), HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(bookService.deleteBookDetails(id), HttpStatus.OK);
    }
}
