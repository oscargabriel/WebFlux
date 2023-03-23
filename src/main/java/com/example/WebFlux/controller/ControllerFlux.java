package com.example.WebFlux.controller;

import com.example.WebFlux.dto.PersonajesDTO;
import com.example.WebFlux.service.ServiceFlux;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerFlux {

    @Autowired
    private ServiceFlux serviceFlux;

    @GetMapping("/test")
    public ResponseEntity<String> gettest(){
        return ResponseEntity.ok("hola mundo");
    }

    @GetMapping("/page/{id}")
    public ResponseEntity<List<PersonajesDTO>> getAll(@PathVariable Integer id){
        return ResponseEntity.ok(serviceFlux.personajesByPage(id));
    }

    @GetMapping("personaje/{id}")
    public ResponseEntity<PersonajesDTO> getFinById(@PathVariable Integer id){
        return ResponseEntity.ok(serviceFlux.personajeFinById(id));
    }

}
