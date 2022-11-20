package com.example.springbootapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractRestController {
    protected <T>ResponseEntity<T> data(T data) {
        return  new ResponseEntity<>(data, HttpStatus.OK);
    }
}
