package com.adocaopets.cadastro.service;

import com.adocaopets.cadastro.dto.PetDTO;
import com.adocaopets.cadastro.model.entity.Pet;
import com.adocaopets.cadastro.model.enums.PetType;
import com.adocaopets.cadastro.model.enums.PetSex;
import com.adocaopets.cadastro.request.PetRequest;

import java.time.LocalDate;
import java.util.List;

public interface PetService {

    int convertAge(LocalDate birthDate);
    PetDTO createPet(PetRequest request);
    PetDTO updatePet(Long id, PetRequest request);
    void deletePet(Long id);
    List<PetDTO> listAll();
    PetDTO listById(Long id);
    List<PetDTO> listByName(String name);
    List<PetDTO> listByNameContainingIgnoreCase(String name);
    List<PetDTO> listBySex(PetSex sex);
    List<PetDTO> listByType(PetType type);
}
