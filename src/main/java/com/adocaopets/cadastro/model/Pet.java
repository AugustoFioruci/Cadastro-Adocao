package com.adocaopets.cadastro.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pets")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    private int age;
    private int weight;
    private String race;

    @Enumerated(EnumType.STRING)
    private TypePet typePet;

    @Enumerated(EnumType.STRING)
    private SexPet sexPet;

}
