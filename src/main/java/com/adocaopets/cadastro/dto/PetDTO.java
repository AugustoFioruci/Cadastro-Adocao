package com.adocaopets.cadastro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.adocaopets.cadastro.model.enums.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {

    private Long id;
    private String name;
    private String address;
    private LocalDate age;
    private int weightInGrams;
    private String race;
    private PetType typePet;
    private PetSex sexPet;
}
