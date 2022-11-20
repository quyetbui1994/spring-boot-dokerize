package com.example.springbootapp.exceptionhandler;

import com.example.springbootapp.exceptionhandler.exception.UserNotFoundException;
import com.example.springbootapp.model.response.ErrorMessage;
import com.example.springbootapp.util.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandlerAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    private ResponseEntity<ErrorMessage> response(ErrorCode error, HttpStatus status) {
        return new ResponseEntity<>(new ErrorMessage(error), status);
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> handle(HttpServletRequest request, UserNotFoundException ex) {
        LOGGER.error("UserNotFoundException with url = {}, ex = {}", request.getRequestURL(), ex);
        return response(ErrorCode.UserNotFound, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handle(MethodArgumentNotValidException ex) {
        Map<String, Object> r = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e -> r.put(e.getField(), e.getDefaultMessage()));
        return new ResponseEntity<>(r, HttpStatus.BAD_REQUEST);
    }
}
