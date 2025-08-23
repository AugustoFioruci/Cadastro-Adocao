package com.adocaopets.cadastro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Address")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String street;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    @NotBlank
    private String city;

    private String neighborhood;

}
