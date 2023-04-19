package com.example.WebFlux.service;

import com.example.WebFlux.dto.PersonajesDTO;
import com.example.WebFlux.exception.DataNotFound;
import com.example.WebFlux.service.Impl.ServiceFluxImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServiceFluxImplTest {

    @Autowired
    ServiceFluxImpl serviceFluxImpl;

    @BeforeEach
    void setUp() {

    }

    /**
     * test para la busqueda de los personajes correspondientes a una pagina
     */
    @Test
    void personajesByPage() {
        List<LinkedHashMap<String,Object>> list = serviceFluxImpl.personajesByPage(1);
        assertNotEquals(null, list);
    }

    /**
     * test la realizar busqueda de un personaje dado su id
     */
    @Test
    void personajeFinById() {
        PersonajesDTO personajesDTO = serviceFluxImpl.personajeFinById(1);
        assertNotEquals(null, personajesDTO);
    }

    /**
     * test la busqueda de un personaje dado su nombre
     */
    @Test
    void personajeFinByName() {
        LinkedHashMap<String, Object> res = serviceFluxImpl.personajeFinByName("Rick Sanchez");
        assertEquals("Rick Sanchez",res.get("name"));
    }

    /**
     * test para la busqueda de un personaje dado un nombre que no se encuentre y devuelva un exception
     */
    @Test
    void personajeFinByNameNotFound() {
        Exception exception = assertThrows(DataNotFound.class, () -> serviceFluxImpl.personajeFinByName("String name"));
        String mensaje = "400 BAD_REQUEST \"No se encontro el personaje de nombre String name\"";
        assertEquals(mensaje,exception.getMessage());

    }

    /**
     * test para la busqueda de personajes correspondientes a una especie
     */
    @Test
    void personajeFinBySpecies() {
        List<String > personajes = serviceFluxImpl.personajeFinBySpecies("Human");
        assertNotNull(personajes);
    }

    /**
     * test cuando no encuentra personajes que correspondan con una especie
     */
    @Test
    void personajeFinBySpeciesNotFound() {
        Exception exception = assertThrows(DataNotFound.class, () -> serviceFluxImpl.personajeFinBySpecies("String name"));
        String mensaje = "400 BAD_REQUEST \"especie String name no encontrada\"";
        assertEquals(mensaje,exception.getMessage());
    }
}