package com.example.WebFlux.controller;

import com.example.WebFlux.dto.PersonajesDTO;
import com.example.WebFlux.service.Impl.ServiceFluxImpl;
import com.example.WebFlux.service.ServiceFlux;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * clase que se encarga de administrar las solicitudes http y llama a service para procesar la solicitud
 * y devolver la respuesta
 */
@RestController
@RequestMapping("/api")
public class ControllerFlux {

    private final ServiceFlux serviceFluxImpl;

    public ControllerFlux(ServiceFluxImpl serviceFluxImpl) {
        this.serviceFluxImpl = serviceFluxImpl;
    }

    /**
     * recibe por parametro en el url un id y llama a serviceFlux para que busque la pagina correspondiente y
     * muestra los personajes de esa pagina
     * @param id Integer de la pagina
     * @return personajes de esa pagina
     */
    @GetMapping("/page/{id}")
    public ResponseEntity<List<LinkedHashMap<String,Object>>> getAll(@PathVariable Integer id){
        return ResponseEntity.ok(serviceFluxImpl.personajesByPage(id));
    }

    /**
     * recibe por parametro en el url un id y llama a serviceFlux para que busque al personaje correspondiente
     * con la id
     * @param id Integer del personaje
     * @return PersonajeDTO correspondiente
     */
    @GetMapping("personajeById/{id}")
    public ResponseEntity<PersonajesDTO> getFinById(@PathVariable Integer id){
        return ResponseEntity.ok(serviceFluxImpl.personajeFinById(id));
    }

    /**
     * recibe por parametro en el url un nombre y llama a serviceFlux para que busque al personaje correspondiente
     * con la id
     * @param name String nombre del personaje
     * @return PersonajeDTO correspondiente
     */
    @GetMapping("personajeByName/{name}")
    public ResponseEntity<LinkedHashMap<String,Object>> getFinByName(@PathVariable String name){
        return ResponseEntity.ok(serviceFluxImpl.personajeFinByName(name));
    }


    @GetMapping("personajeBySpecies/{species}")
    public ResponseEntity<List<String>> getAllFinBySpecies(@PathVariable String species){
        return ResponseEntity.ok(serviceFluxImpl.personajeFinBySpecies(species));
    }
}
