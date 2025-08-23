package com.adocaopets.cadastro.repository;

import com.adocaopets.cadastro.model.entity.Pet;
import com.adocaopets.cadastro.model.enums.PetType;
import com.adocaopets.cadastro.model.enums.SexPet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {


    List<Pet> findByName(String name);
    List<Pet> findByNameContainingIgnoreCase(String name);
    List<Pet> findByTypePet(PetType typePet);
    List<Pet> findBySexPet(SexPet sexPet);
}
