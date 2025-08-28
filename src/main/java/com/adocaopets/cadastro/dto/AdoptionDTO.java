package com.adocaopets.cadastro.dto;

import com.adocaopets.cadastro.model.entity.Adoption;
import com.adocaopets.cadastro.model.enums.AdoptionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdoptionDTO {
    private Long id;
    private Long petId;
    private Long ownerId;
    private String petName;
    private String ownerName;
    private LocalDate adoptionTime;
    private LocalDate returnDate;
    private AdoptionStatus status;

    public static AdoptionDTO fromEntity(Adoption adoption) {
        return AdoptionDTO.builder()
                .id(adoption.getId())
                .petId(adoption.getPet().getId())
                .ownerId(adoption.getOwner().getId())
                .petName(adoption.getPet().getName())
                .ownerName(adoption.getOwner().getName())
                .adoptionTime(adoption.getReturnDate())
                .returnDate(adoption.getReturnDate())
                .status(adoption.getAdoptionStatus())
                .build();
    }
}
