package com.adocaopets.cadastro.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Owner")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    private Address address;
    private int telephoneNumber;
}
