package com.example.WebFlux.service;

import com.example.WebFlux.dto.PersonajesDTO;
import com.example.WebFlux.exception.DataNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServiceFluxTest {

    @Autowired
    ServiceFlux serviceFlux;

    @BeforeEach
    void setUp() {

    }

    @Test
    void personajesByPage() {
        List<LinkedHashMap<String,Object>> list = serviceFlux.personajesByPage(1);
        assertNotEquals(null, list);
    }

    @Test
    void personajeFinById() {
        PersonajesDTO personajesDTO = serviceFlux.personajeFinById(1);
        assertNotEquals(null, personajesDTO);
    }

    @Test
    void personajeFinByName() {
        LinkedHashMap<String, Object> res = serviceFlux.personajeFinByName("Rick Sanchez");
        assertEquals("Rick Sanchez",res.get("name"));
    }
    @Test
    void personajeFinByNameNotFound() {
        Exception exception = assertThrows(DataNotFound.class, () -> serviceFlux.personajeFinByName("String name"));
        String mensaje = "400 BAD_REQUEST \"No se encontro el personaje de nombre String name\"";
        assertEquals(mensaje,exception.getMessage());

    }

    @Test
    void personajeFinBySpecies() {
        List<String > personajes = serviceFlux.personajeFinBySpecies("Human");
        assertNotNull(personajes);
    }

    @Test
    void personajeFinBySpeciesNotFound() {
        Exception exception = assertThrows(DataNotFound.class, () -> serviceFlux.personajeFinBySpecies("String name"));
        String mensaje = "400 BAD_REQUEST \"especie String name no encontrada\"";
        assertEquals(mensaje,exception.getMessage());
    }
}