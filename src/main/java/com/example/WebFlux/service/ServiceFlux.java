package com.example.WebFlux.service;

import com.example.WebFlux.dto.PersonajesDTO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.LinkedHashMap;
import java.util.List;

@Service
@NoArgsConstructor
public class ServiceFlux {

    @Autowired
    private RestTemplate restTemplate;



    public List<PersonajesDTO> personajesByPage(Integer id){
        String url = "https://rickandmortyapi.com/api/character?page="+id;
        try {
            LinkedHashMap<String, Object> res = restTemplate.getForObject(url, LinkedHashMap.class);
            return (List<PersonajesDTO>) res.get("results");
        }catch (HttpClientErrorException e){
            System.out.println("pagina no encontrada");//TODO generar una exepcion para el return correspondiente
        }
        return null;
    }

    public PersonajesDTO personajeFinById(Integer id){
        String url = "https://rickandmortyapi.com/api/character/"+id;
        try {
            PersonajesDTO res = restTemplate.getForObject(url, PersonajesDTO.class);
            return res;
        }catch (HttpClientErrorException e){
            System.out.println("personaje no encontrada");//TODO generar una exepcion para el return correspondiente
        }
        return null;
    }

    public LinkedHashMap<String,Object> personajeFinByName(String name){

        for (int i = 0; i < 42; i++) {
            LinkedHashMap<String, Object> res = restTemplate.getForObject(
                    "https://rickandmortyapi.com/api/character?page="+(i+1),
                    LinkedHashMap.class);
            List<LinkedHashMap<String,Object>> personajes = (List<LinkedHashMap<String,Object>>) res.get("results");

            for (LinkedHashMap<String,Object> personaje : personajes){
                System.out.println(personaje.get("name"));
                if(name.equalsIgnoreCase((String)personaje.get("name"))){
                    return personaje;
                }
            }
        }
        System.out.println("no se encontro el personaje");

        return null;
    }

}
