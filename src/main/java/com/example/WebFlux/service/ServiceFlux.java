package com.example.WebFlux.service;

import com.example.WebFlux.dto.PersonajesDTO;
import com.example.WebFlux.exception.DataNotFound;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * servicio para procesar las socitudes y enviar una respuesta
 */
@Service
@NoArgsConstructor
public class ServiceFlux {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * recibe un numero de pagina y devuelve los personajes que tenga la pagina
     * @param id Integer del numero de la pagina
     * @return personajes por pagina
     */
    public List<LinkedHashMap<String,Object>>personajesByPage(Integer id){
        String url = "https://rickandmortyapi.com/api/character?page="+id;
        try {
            LinkedHashMap<String, Object> res = restTemplate.getForObject(url, LinkedHashMap.class);
            return (List<LinkedHashMap<String,Object>>) res.get("results");
        }catch (HttpClientErrorException e){
            throw new DataNotFound(HttpStatus.BAD_REQUEST,"No se encontro la pagina numero "+id);
        }
    }

    /**
     * busca un personaje por su id la cual tiene un url para cada uno
     * @param id Integer del personaje
     * @return personaje si lo encuentra
     */
    public PersonajesDTO personajeFinById(Integer id){
        String url = "https://rickandmortyapi.com/api/character/"+id;
        try {
            PersonajesDTO res = restTemplate.getForObject(url, PersonajesDTO.class);
            return res;
        }catch (HttpClientErrorException e){
            throw new DataNotFound(HttpStatus.BAD_REQUEST,"No se encontro el personaje de id "+id);
        }
    }

    /**
     * busca un personaje por su nombre, hace una peticion de cada pagina y va revisando los nombres de esa
     * pagina, si no lo encuentra pasa a la siguiente pagina hasta terminar
     * @param name String del personaje
     * @return personaje si lo encuentra
     */
    public LinkedHashMap<String,Object> personajeFinByName(String name){
        //trae la paginas por orden
        for (int i = 0; i < 42; i++) {
            LinkedHashMap<String, Object> res = restTemplate.getForObject(
                    "https://rickandmortyapi.com/api/character?page="+(i+1),
                    LinkedHashMap.class);
            //extrae la lista de personajes de la pagina
            List<LinkedHashMap<String,Object>> personajes = (List<LinkedHashMap<String,Object>>) res.get("results");
            //recorre la lista de personajes para identificar el que corresponda
            for (LinkedHashMap<String,Object> personaje : personajes){
                if(name.equalsIgnoreCase((String)personaje.get("name"))){
                    return personaje;
                }
            }
        }
        throw new DataNotFound(HttpStatus.BAD_REQUEST,"No se encontro el personaje de nombre "+name);
    }

    /**
     * buscar los personajes que pertenescan a una especie dada por el usuario
     * @param species String dado
     * @return Lista de nombres
     */
    public List<String> personajeFinBySpecies(String species) {
        
        List<LinkedHashMap<String,Object>> personajesDTOS;
        List<String > personajes = new ArrayList<>();
        for (int i = 1; i < 43; i++) {
            personajesDTOS = personajesByPage(i);
            personajesDTOS.forEach(x->{
                if(species.equalsIgnoreCase((String) x.get("species"))) {
                    personajes.add((String) x.get("name"));
                }
            });
        }

        if(personajes.size()==0){
            throw new DataNotFound(HttpStatus.BAD_REQUEST,"especie "+ species+" no encontrada");
        }



        return personajes;
    }
}
