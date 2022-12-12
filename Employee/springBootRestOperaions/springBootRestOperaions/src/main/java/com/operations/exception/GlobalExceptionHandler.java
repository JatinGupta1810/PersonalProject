package com.operations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> throwGlobalException(Exception exception) {

        ErrorMessage errorMessage = new ErrorMessage(111, "Global excpetion called");
        return new ResponseEntity<>(errorMessage, HttpStatus.EXPECTATION_FAILED);
    }

    /*@ExceptionHandler(Exception.class)
    public @ResponseBody ErrorMessage throwGlobalException(Exception exception) {

        return new ErrorMessage(111, "Global excpetion called");
    }*/
}
