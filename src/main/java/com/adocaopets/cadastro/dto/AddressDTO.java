package com.adocaopets.cadastro.dto;

import com.adocaopets.cadastro.model.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;
    private String street;
    private int number;
    private String city;
    private String neighborhood;

    public static AddressDTO fromEntity(Address address){
        return AddressDTO.builder()
                .id(address.getId())
                .street(address.getStreet())
                .number(address.getNumber())
                .city(address.getCity())
                .neighborhood(address.getNeighborhood())
                .build();
    }
}
