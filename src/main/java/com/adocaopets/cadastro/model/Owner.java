package com.adocaopets.cadastro.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "owner")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 11)
    @NotBlank
    @CPF
    private String cpf;

    @OneToOne
    @JoinColumn(name = "address_id")
    @NotNull
    private Address address;

    private int telephoneNumber;

    public void setCpf(String cpf) {
        this.cpf = cpf.replaceAll("\\D", "");
    }

}
