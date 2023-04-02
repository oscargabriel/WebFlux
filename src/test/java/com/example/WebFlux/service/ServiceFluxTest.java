package com.example.WebFlux.service;

import com.example.WebFlux.Rest.RestFlux;
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
    }

    @Test
    void personajeFinByName() {
    }

    @Test
    void personajeFinBySpecies() {
    }
}