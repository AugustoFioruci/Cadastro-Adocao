package com.adocaopets.cadastro.service;

import com.adocaopets.cadastro.model.*;

import java.util.List;

public interface PetService {

    Pet createPet(Pet pet);
    Pet updatePet(Long id, Pet petUpdated);
    void deletePet(Long id);
    List<Pet> listAll();
    List<Pet> listByName(String name);
    List<Pet> listByNameContainingIgnoreCase(String name);
    List<Pet> listBySex(SexPet sex);
    List<Pet> listByType(PetType type);
}
