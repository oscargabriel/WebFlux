package com.example.WebFlux.service;

import com.example.WebFlux.dto.PersonajesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Service
public class ServiceFlux {

    @Autowired
    private RestTemplate restTemplate;



    public Object personajes(){
        String url = "https://rickandmortyapi.com/api/character?page=1";
        LinkedHashMap<Object,Object> res = restTemplate.getForObject(url, LinkedHashMap.class);
        System.out.println("1"+res.get("info").getClass().getName());
        System.out.println("2"+res.get("results").getClass().getName());
        //ArrayList<HashMap<String,String>> lista = (ArrayList<HashMap<String,String>> ) res.get("results");
        return res;
    }


    public PersonajesDTO personajeFinById(Integer id){
        String url = "https://rickandmortyapi.com/api/character/"+id;
        PersonajesDTO res = restTemplate.getForObject(url, PersonajesDTO.class);
        return res;
    }

}
