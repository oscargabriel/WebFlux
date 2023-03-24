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


/**
 * clase para el control de expeciones causadas por datos no encontrados
 * genera un mensaje el cual se envia para indicar el problema
 */
@ControllerAdvice
public class ExeptionController extends ResponseEntityExceptionHandler {

    /**
     * exepcion pra personajes o paginas no encontradas
     * @param exception informacion correspondiente a la exepcion
     * @return el map con la informacion necesaria para indicar el causante del problema
     */
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
