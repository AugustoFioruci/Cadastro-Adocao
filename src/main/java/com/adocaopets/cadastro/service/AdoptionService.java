package com.adocaopets.cadastro.service;

import com.adocaopets.cadastro.model.*;
import java.util.List;

public interface AdoptionService {

    Adoption createAdoption(Pet pet, Owner owner);
    Adoption updateAdoption(Long id, Adoption adoptionUpdated);
    void deleteAdoption(Long id);
    List<Adoption> listAll();
    List<Owner> listByCpf(String cpf);
    List<Adoption> findByPetId(Long id);
}
