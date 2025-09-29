package com.adocaopets.cadastro.service;

import com.adocaopets.cadastro.dto.AdoptionDTO;
import com.adocaopets.cadastro.request.AdoptionRequest;
import com.adocaopets.cadastro.model.entity.Adoption;

import java.util.List;

public interface AdoptionService {

    AdoptionDTO createAdoption(AdoptionRequest request);
    AdoptionDTO updateAdoption(AdoptionRequest request, Long id);
    AdoptionDTO cancelAdoption(Long id);
    AdoptionDTO listById(Long id);
    List<AdoptionDTO> listAdoptionByPetIdAndOwnerCpf(Long id, String cpf);
    List<AdoptionDTO> listAll();
    List<AdoptionDTO> listByOwnerCpf(String cpf);
    List<AdoptionDTO> listByPetId(Long id);
}
