package com.adocaopets.cadastro.service;

import com.adocaopets.cadastro.model.entity.Pet;
import com.adocaopets.cadastro.model.enums.PetType;
import com.adocaopets.cadastro.model.enums.PetSex;

import java.time.LocalDate;
import java.util.List;

public interface PetService {

    int convertAge(LocalDate birthDate);
    Pet createPet(Pet pet);
    Pet updatePet(Long id, Pet petUpdated);
    void deletePet(Long id);
    List<Pet> listAll();
    List<Pet> listByName(String name);
    List<Pet> listByNameContainingIgnoreCase(String name);
    List<Pet> listBySex(PetSex sex);
    List<Pet> listByType(PetType type);
}
