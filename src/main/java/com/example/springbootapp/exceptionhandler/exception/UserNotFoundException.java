package com.example.springbootapp.exceptionhandler.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {super(message);}
}
