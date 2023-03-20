package com.kitaplik.libraryservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

/*    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?> handle(BookNotFoundException bookNotFoundException){
        return new ResponseEntity<>(bookNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }*/

    @ExceptionHandler(LibraryNotFoundException.class)
    public ResponseEntity<String> handle(LibraryNotFoundException libraryNotFoundException){
        return new ResponseEntity<>(libraryNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ExceptionMessage> handle(BookNotFoundException exception){
        return new ResponseEntity<>(exception.getExceptionMessage(),
                HttpStatus.resolve(exception.getExceptionMessage().status()));
    }
}
