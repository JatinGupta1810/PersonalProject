package com.jatin.springbootservcie.service;

import com.jatin.springbootservcie.entity.Book;

import java.util.List;

public interface BookService {

    //sace details
    Book saveBookDetails(Book book);

    //Get details
    List<Book> fetachAllDetails();

    //Update details
    Book updateBookDetails(Book book, Integer id);

    //Delete details
    String deleteBookDetails(Integer id);
}
