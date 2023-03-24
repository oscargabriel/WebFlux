package com.example.WebFlux.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExeptionController extends ResponseEntityExceptionHandler {
    Logger log = LoggerFactory.getLogger(ExeptionController.class);

    @ExceptionHandler(DataNotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String,Object>> handleDataNotFound(DataNotFound exception){
        Map<String,Object> data = new HashMap<>();
            data.put("timestamp",new Date());
            data.put("status",HttpStatus.BAD_REQUEST);
            data.put("reason",exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(data);
    }
}
