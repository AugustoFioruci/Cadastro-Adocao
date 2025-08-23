package com.adocaopets.cadastro.service;

import com.adocaopets.cadastro.dto.AdoptionRequest;
import com.adocaopets.cadastro.model.enity.Adoption;
import com.adocaopets.cadastro.model.enity.Owner;

import java.util.List;

public interface AdoptionService {

    Adoption createAdoption(AdoptionRequest adoptionRequest);
    Adoption updateAdoption(Long id, Adoption adoptionUpdated);
    void deleteAdoption(Long id);
    List<Adoption> listAll();
    List<Owner> listByCpf(String cpf);
    List<Adoption> findByPetId(Long id);
}
