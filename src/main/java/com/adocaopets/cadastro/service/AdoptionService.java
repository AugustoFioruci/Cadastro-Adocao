package com.adocaopets.cadastro.service;

import com.adocaopets.cadastro.dto.AdoptionRequest;
import com.adocaopets.cadastro.model.entity.Adoption;

import java.util.List;

public interface AdoptionService {

    Adoption createAdoption(AdoptionRequest request);
    Adoption updateAdoption(AdoptionRequest request, Long id);
    Adoption cancelAdoption(Long id);
    List<Adoption> listAdoptionByPetIdAndOwnerCpf(Long id, String cpf);
    List<Adoption> listAll();
    List<Adoption> listByOwnerCpf(String cpf);
    List<Adoption> listByPetId(Long id);
}
