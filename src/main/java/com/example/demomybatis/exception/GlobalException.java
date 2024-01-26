package com.example.demomybatis.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;

@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail problemDetail(NotFoundException notFoundException){
        ProblemDetail problemDetail=ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,notFoundException.getMessage());
       problemDetail.setType(URI.create("https://localhost:8080/error"));
        return problemDetail;
    }

}
