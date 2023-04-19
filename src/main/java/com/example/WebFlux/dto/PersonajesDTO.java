package com.example.WebFlux.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.HashMap;
import java.util.List;

/**
 * Entidad para un uso mas codo al extraer datos de la api de rickandmortyapi
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonajesDTO {

    private Integer id;

    private String name;

    private String status;

    private String species;

    private String type;

    private String gender;

    private HashMap<String,String> origin;

    private HashMap<String,String> location;

    private String image;

    private List<String> episode;

    private String url;

    private String created;

}
