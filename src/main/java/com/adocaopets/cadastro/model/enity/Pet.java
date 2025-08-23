package com.adocaopets.cadastro.model.enity;

import com.adocaopets.cadastro.model.enums.PetType;
import com.adocaopets.cadastro.model.enums.SexPet;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "pets")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String name;

    @Column(nullable = false)
    @NotBlank
    private String address;

    private LocalDate age;
    private int weight;
    private String race;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private PetType typePet;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private SexPet sexPet;

}
