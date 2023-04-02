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
    void personajeFinByNameNotFound() {

        Exception exception = assertThrows(DataNotFound.class, () -> serviceFlux.personajeFinByName("String name"));
        String mensaje = "400 BAD_REQUEST \"No se encontro el personaje de nombre String name\"";
        assertEquals(mensaje,exception.getMessage());

    }

    @Test
    void personajeFinBySpeciesNotFound() {
        Exception exception = assertThrows(DataNotFound.class, () -> serviceFlux.personajeFinBySpecies("String name"));
        String mensaje = "400 BAD_REQUEST \"especie String name no encontrada\"";
        System.out.println(exception.getMessage());
        assertEquals(mensaje,exception.getMessage());
    }
}