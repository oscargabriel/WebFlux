package com.example.WebFlux.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonajesDTO {

    private Integer id;

    private String status;

    private String type;

    private String gender;

    private HashMap<String,String> origin;

    private HashMap<String,String> location;

    private String image;

    private List<String> episode;

    private String url;

    private String created;

}
