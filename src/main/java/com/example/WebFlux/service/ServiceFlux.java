package com.example.WebFlux.service;

import com.example.WebFlux.dto.PersonajesDTO;

import java.util.LinkedHashMap;
import java.util.List;

public interface ServiceFlux {
    public List<LinkedHashMap<String,Object>> personajesByPage(Integer id);

    public PersonajesDTO personajeFinById(Integer id);

    public LinkedHashMap<String,Object> personajeFinByName(String name);

    public List<String> personajeFinBySpecies(String species);

}
