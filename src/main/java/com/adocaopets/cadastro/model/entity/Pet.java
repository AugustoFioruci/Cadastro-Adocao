package com.adocaopets.cadastro.model.entity;

import com.adocaopets.cadastro.model.enums.PetType;
import com.adocaopets.cadastro.model.enums.PetSex;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@Table(name = "pets")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    private LocalDate birthDate;
    private int weightInGrams;
    private String race;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PetType typePet;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PetSex sexPet;

}
