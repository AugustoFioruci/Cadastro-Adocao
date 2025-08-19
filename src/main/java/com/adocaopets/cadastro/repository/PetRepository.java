package com.adocaopets.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adocaopets.cadastro.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {

    // Buscar por nome exato
    List<Pet> findByName(String name);

    // Buscar por parte do nome (contendo)
    List<Pet> findByNameContainingIgnoreCase(String name);

    // Buscar por tipo de pet
    List<Pet> findByTypePet(PetType typePet);

    // Buscar por sexo do pet
    List<Pet> findBySexPet(SexPet sexPet);
}
