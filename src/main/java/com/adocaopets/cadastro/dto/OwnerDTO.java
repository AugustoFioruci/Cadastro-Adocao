package com.adocaopets.cadastro.dto;

import com.adocaopets.cadastro.model.entity.Address;
import com.adocaopets.cadastro.model.entity.Owner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDTO {

    private Long id;
    private String name;
    private String cpf;
    private Address address;
    private String telephoneNumber;

    public static OwnerDTO fromEntity(Owner owner){
        return OwnerDTO.builder()
                .id(owner.getId())
                .name(owner.getName())
                .cpf(owner.getCpf())
                .address(owner.getAddress())
                .telephoneNumber(owner.getTelephoneNumber())
                .build();
    }
}
