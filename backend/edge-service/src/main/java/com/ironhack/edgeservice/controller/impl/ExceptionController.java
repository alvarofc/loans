package com.ironhack.edgeservice.controller.impl;

import com.ironhack.edgeservice.config.FeignBadResponseWrapper;
import com.ironhack.edgeservice.exceptions.Error;
import com.ironhack.edgeservice.exceptions.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        String errorMessage = e.toString().substring(e.toString().length() - 26);
        Error error = new Error();
            error.setMessage(errorMessage.substring(errorMessage.indexOf("[") + 1, errorMessage.indexOf("]")));
            error.setStatus(HttpStatus.BAD_REQUEST.toString());
            error.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<Error> handleObjectNotFound(IdNotFoundException e) {
        Error error = new Error();
            error.setMessage(e.getMessage());
            error.setStatus(HttpStatus.NOT_FOUND.toString());
            error.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Error> handleRunTimeException(RuntimeException e) {
        Error error = new Error();
            error.setMessage(e.getMessage());
            error.setStatus((e.getMessage().contains("exist") ? HttpStatus.NOT_FOUND.toString() : HttpStatus.INTERNAL_SERVER_ERROR.toString()));
            error.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<>(error, e.getMessage().contains("exist") ? HttpStatus.NOT_FOUND : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchMethodException.class)
    public ResponseEntity<Error> handleNoSuchMethodException(NoSuchMethodException e) {
        Error error = new Error();
            error.setMessage(e.getMessage());
            error.setStatus(HttpStatus.BAD_REQUEST.toString());
            error.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(FeignBadResponseWrapper.class)
    public ResponseEntity<Error> handleFeignBadResponse(FeignBadResponseWrapper e) {
        Error error = new Error();
        error.setMessage(e.getMessage());
        if (e.getStatus()==404){
            error.setStatus(HttpStatus.NOT_FOUND.toString());
            error.setLocalDateTime(LocalDateTime.now());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
        error.setStatus(HttpStatus.BAD_REQUEST.toString());
        error.setLocalDateTime(LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
