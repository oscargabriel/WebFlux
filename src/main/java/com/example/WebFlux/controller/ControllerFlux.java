package com.example.WebFlux.controller;

import com.example.WebFlux.service.ServiceFlux;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerFlux {

    @Autowired
    private ServiceFlux serviceFlux;

    @GetMapping("/test")
    public ResponseEntity<String> gettest(){
        return ResponseEntity.ok("hola mundo");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(serviceFlux.personajes());
    }
}
