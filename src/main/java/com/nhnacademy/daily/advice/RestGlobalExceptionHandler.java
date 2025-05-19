package com.nhnacademy.daily.advice;

import com.nhnacademy.daily.exception.ResourceAlreadyExistsException;
import com.nhnacademy.daily.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestGlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleException(ResourceNotFoundException e) {
        return new ResponseEntity<>("리소스를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<String> handleException(ResourceAlreadyExistsException e) {
        return new ResponseEntity<>("이미 존재하는 id or code 입니다.", HttpStatus.CONFLICT);
    }
}
