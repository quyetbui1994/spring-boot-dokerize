package com.example.springbootapp.util;

import lombok.Getter;

@Getter
public enum ErrorCode {
    UserNotFound("ERROR-001", "user not found");

    private final String code;
    private final String message;
    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
