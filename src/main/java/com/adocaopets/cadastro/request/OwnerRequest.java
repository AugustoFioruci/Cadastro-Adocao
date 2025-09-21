package com.adocaopets.cadastro.request;

import com.adocaopets.cadastro.model.entity.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String cpf;
    private Address address;
    @NotNull
    private String telephoneNumber;
}
