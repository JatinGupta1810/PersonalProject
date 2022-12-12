package com.jatin.springbootservcie.repository;

import com.jatin.springbootservcie.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository  not reuired because JpaRepository already contains this annotation
public interface BookRepository extends JpaRepository<Book, Integer> {
}
