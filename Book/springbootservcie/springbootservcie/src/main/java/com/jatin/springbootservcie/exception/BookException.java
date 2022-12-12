package com.jatin.springbootservcie.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookException extends RuntimeException {

    private Object id;

    public BookException(Object id) {
        super(String.format("Book Id %s is not present in database", id));
        this.id = id;
    }
}
