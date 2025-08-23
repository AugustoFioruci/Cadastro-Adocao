package com.adocaopets.cadastro.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdoptionRequest {
    private Long ownerId;
    private Long petId;
}
