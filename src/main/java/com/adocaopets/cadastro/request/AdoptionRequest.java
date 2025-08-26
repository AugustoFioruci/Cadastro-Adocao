package com.adocaopets.cadastro.request;


import com.adocaopets.cadastro.model.enums.AdoptionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdoptionRequest {
    private Long ownerId;
    private Long petId;
    private LocalDate returnDate;
    private AdoptionStatus status;
}
