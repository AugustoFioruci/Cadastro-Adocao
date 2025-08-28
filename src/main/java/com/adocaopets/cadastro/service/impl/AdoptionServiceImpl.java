package com.adocaopets.cadastro.service.impl;

import com.adocaopets.cadastro.dto.AdoptionDTO;
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
    public AdoptionDTO createAdoption(AdoptionRequest request) {

        Owner owner = getOwnerById(request.getOwnerId());
        Pet pet = getPetById(request.getPetId());

        Adoption adoption = Adoption.builder()
                .owner(owner)
                .pet(pet)
                .adoptionTime(LocalDate.now())
                .adoptionStatus(AdoptionStatus.ADOPTED)
                .build();

        Adoption saveAdoption = adoptionRepository.save(adoption);

        return AdoptionDTO.fromEntity(saveAdoption);
    }

    @Override
    public AdoptionDTO updateAdoption(AdoptionRequest request, Long adoptionId){
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
        Adoption updateAdoption = adoptionRepository.save(adoption);

        return AdoptionDTO.fromEntity(updateAdoption);
    }

    @Override
    public AdoptionDTO cancelAdoption(Long adoptionId){
        Adoption adoption = adoptionRepository.findById(adoptionId).orElseThrow(() ->
                new RuntimeException("Adoção não encontrada"));
        adoption.setReturnDate(LocalDate.now());
        adoption.setAdoptionStatus(AdoptionStatus.RETURNED);

        Adoption cancelAdoption = adoptionRepository.save(adoption);

        return AdoptionDTO.fromEntity(cancelAdoption);
    }

    @Override
    public List<AdoptionDTO> listAdoptionByPetIdAndOwnerCpf(Long petId, String cpf){
        return adoptionRepository.findByPetIdAndOwnerCpf(petId, cpf)
                .stream()
                .map(AdoptionDTO::fromEntity)
                .toList();
    }

    @Override
    public List<AdoptionDTO> listAll(){
        return adoptionRepository.findAll()
                .stream()
                .map(AdoptionDTO::fromEntity)
                .toList();
    }

    @Override
    public List<AdoptionDTO> listByOwnerCpf(String cpf){
        return adoptionRepository.findByOwnerCpf(cpf)
                .stream()
                .map(AdoptionDTO::fromEntity)
                .toList();
    }

    @Override
    public List<AdoptionDTO> listByPetId(Long petId){
        return adoptionRepository.findByPetId(petId)
                .stream()
                .map(AdoptionDTO::fromEntity)
                .toList();
    }
}
