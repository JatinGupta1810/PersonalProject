package com.jatin.springbootservcie.service;

import com.jatin.springbootservcie.entity.Book;
import com.jatin.springbootservcie.exception.BookException;
import com.jatin.springbootservcie.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {


    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBookDetails(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public List<Book> fetachAllDetails() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBookDetails(Book book, Integer id) {
        Optional<Book> optional = bookRepository.findById(id);
        if (!optional.isPresent())
            return optional.orElseThrow(() -> {
                return new BookException(id);
            });

        Book existingBook = optional.get();
        existingBook.setBookName(book.getBookName());
        existingBook.setPrice(book.getPrice());
        existingBook.setIsAvailable(book.getIsAvailable());
        bookRepository.save(existingBook);
        return existingBook;
    }

    @Override
    public String deleteBookDetails(Integer id) {

        Optional<Book> deleteBook = bookRepository.findById(id);
        if (deleteBook.isPresent()) {
            bookRepository.deleteById(id);
            return "Book deleted successfully";
        } else {
            return "Given Book Id cant be deleted";
        }

    }

}