package com.adocaopets.cadastro.repository;

import com.adocaopets.cadastro.dto.PetDTO;
import com.adocaopets.cadastro.model.entity.Pet;
import com.adocaopets.cadastro.model.enums.PetType;
import com.adocaopets.cadastro.model.enums.PetSex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {


    List<PetDTO> findByName(String name);
    List<PetDTO> findByNameContainingIgnoreCase(String name);
    List<PetDTO> findByTypePet(PetType typePet);
    List<PetDTO> findBySexPet(PetSex petSex);
}
