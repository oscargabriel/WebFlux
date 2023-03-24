package com.example.WebFlux.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;


public class DataNotFound extends ResponseStatusException {

    public DataNotFound(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
