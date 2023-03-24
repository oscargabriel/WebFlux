package com.example.WebFlux.exception;


import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

/**
 * exception para los datos que no se pudieron encontrar
 * nombre de personaje, id de personaje o numero de pagina
 */
public class DataNotFound extends ResponseStatusException {

    public DataNotFound(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
