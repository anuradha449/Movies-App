package com.srgec.movies_app.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.srgec.movies_app.dto.ErrorResponse;
import com.srgec.movies_app.exception.UserNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String handlUserNotFoundExpcetion(UserNotFoundException exception) {
        return exception.getMessage();
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex){
        return  ResponseEntity.status(400).body(new ErrorResponse(ex.getMessage()));
    }

}