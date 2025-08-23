package com.adocaopets.cadastro.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    @NotNull
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @NotNull
    private Owner owner;

    @Column(nullable = false)
    @NotNull
    private LocalDate adoptionTime;
    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private AdoptionStatus adoptionStatus;
}
