package com.adocaopets.cadastro.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.adocaopets.cadastro.model.enums.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String name;
    @NotBlank(message = "Endereço é obrigatório")
    private String addressPetFound;
    @NotBlank(message = "Tipo é obrigatório")
    private PetType typePet;
    @NotBlank(message = "Sexo é obrigatório")
    private PetSex sexPet;

    private LocalDate birthDate;
    private int weightInGrams;
    private String race;

}
