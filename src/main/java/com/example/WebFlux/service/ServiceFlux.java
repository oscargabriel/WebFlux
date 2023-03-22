package com.example.WebFlux.service;

import com.example.WebFlux.dto.RickAndMortyApi;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Service
public class ServiceFlux {

    @Autowired
    private RestTemplate restTemplate;

    String url = "https://rickandmortyapi.com/api/character?page=1";

    public ArrayList<HashMap> personajes(){
        LinkedHashMap res = restTemplate.getForObject(url, LinkedHashMap.class);
        ArrayList<HashMap> lin = (ArrayList) res.get("results");
        return lin;
    }

}
