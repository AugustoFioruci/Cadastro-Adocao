package com.adocaopets.cadastro.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    @NotBlank
    private String street;
    @NotNull
    private int number;
    @NotBlank
    private String city;
    private String neighborhood;
}
