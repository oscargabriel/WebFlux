package com.example.WebFlux.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
public class RickAndMortyApi {

    private Object info;

    private List<Object> results;


}
