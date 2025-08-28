package com.adocaopets.cadastro.request;


import com.adocaopets.cadastro.model.enums.AdoptionStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdoptionRequest {

    @NotNull
    private Long ownerId;
    @NotNull
    private Long petId;
    @NotNull
    private LocalDate returnDate;
    @NotBlank
    private AdoptionStatus status;
}
