package com.adocaopets.cadastro.service.impl;

import com.adocaopets.cadastro.request.AdoptionRequest;
import com.adocaopets.cadastro.model.entity.Adoption;
import com.adocaopets.cadastro.model.entity.Owner;
import com.adocaopets.cadastro.model.entity.Pet;
import com.adocaopets.cadastro.model.enums.AdoptionStatus;
import com.adocaopets.cadastro.repository.*;
import com.adocaopets.cadastro.service.AdoptionService;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdoptionServiceImpl implements AdoptionService {

    private final AdoptionRepository adoptionRepository;
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;

    private Owner getOwnerById(Long ownerId){
        return ownerRepository.findById(ownerId).orElseThrow(
                () -> new RuntimeException("Dono não encontrado"));
    }

    private Pet getPetById(Long petId){
        return petRepository.findById(petId).orElseThrow(
                () -> new RuntimeException("Animal não encontrado"));
    }

    @Override
    public Adoption createAdoption(AdoptionRequest request) {

        Owner owner = getOwnerById(request.getOwnerId());
        Pet pet = getPetById(request.getPetId());

        Adoption adoption = Adoption.builder().
                owner(owner).
                pet(pet).
                adoptionTime(LocalDate.now()).
                adoptionStatus(AdoptionStatus.ADOPTED).
                build();

        return adoptionRepository.save(adoption);
    }

    @Override
    public Adoption updateAdoption(AdoptionRequest request, Long adoptionId){
        Adoption adoption = adoptionRepository.findById(adoptionId).orElseThrow(() ->
                new RuntimeException("Adoção não encontrada"));
        Owner owner = getOwnerById(request.getOwnerId());
        Pet pet = getPetById(request.getPetId());

        adoption.setOwner(owner);
        adoption.setPet(pet);
        adoption.setAdoptionStatus(request.getStatus());
        if(request.getReturnDate() != null){
            adoption.setReturnDate(request.getReturnDate());
        }
        return adoptionRepository.save(adoption);
    }

    @Override
    public Adoption cancelAdoption(Long adoptionId){
        Adoption adoption = adoptionRepository.findById(adoptionId).orElseThrow(() ->
                new RuntimeException("Adoção não encontrada"));
        adoption.setReturnDate(LocalDate.now());
        adoption.setAdoptionStatus(AdoptionStatus.RETURNED);
        return adoptionRepository.save(adoption);
    }

    @Override
    public List<Adoption> listAdoptionByPetIdAndOwnerCpf(Long petId, String cpf){
        return adoptionRepository.findByPetIdAndOwnerCpf(petId, cpf);
    }

    @Override
    public List<Adoption> listAll(){
        return adoptionRepository.findAll();
    }

    @Override
    public List<Adoption> listByOwnerCpf(String cpf){
        return adoptionRepository.findByOwnerCpf(cpf);
    }

    @Override
    public List<Adoption> listByPetId(Long petId){
        return adoptionRepository.findByPetId(petId);
    }
}
