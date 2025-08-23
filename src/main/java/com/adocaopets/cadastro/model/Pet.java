package com.adocaopets.cadastro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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

    private int age;
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
