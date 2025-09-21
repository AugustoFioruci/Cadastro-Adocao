package com.adocaopets.cadastro.service.impl;

import com.adocaopets.cadastro.dto.PetDTO;
import com.adocaopets.cadastro.model.entity.Pet;
import com.adocaopets.cadastro.model.enums.PetType;
import com.adocaopets.cadastro.model.enums.PetSex;
import com.adocaopets.cadastro.repository.PetRepository;
import com.adocaopets.cadastro.request.PetRequest;
import com.adocaopets.cadastro.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Override
    public int convertAge(LocalDate birthDate){
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public PetDTO createPet(PetRequest request){
        Pet pet = Pet.builder()
                .name(request.getName())
                .addressPetFound(request.getAddressPetFound())
                .typePet(request.getTypePet())
                .sexPet(request.getSexPet())
                .birthDate(request.getBirthDate())
                .weightInGrams(request.getWeightInGrams())
                .race(request.getRace())
                .build();

        Pet createPet = petRepository.save(pet);

        return PetDTO.fromEntity(createPet);

    }

    @Override
    public PetDTO updatePet(Long id, PetRequest request){
        Pet pet = petRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal não encontrado"));

        pet.setName(request.getName());
        pet.setTypePet(request.getTypePet());
        pet.setSexPet(request.getSexPet());
        pet.setBirthDate(request.getBirthDate());
        pet.setWeightInGrams(request.getWeightInGrams());
        pet.setRace(request.getRace());
        pet.setAddressPetFound(request.getAddressPetFound());

        Pet updatedPet = petRepository.save(pet);

        return PetDTO.fromEntity(updatedPet);

    }

    @Override
    public void deletePet(Long id){

        Pet pet = petRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal não encontrado"));

        petRepository.deleteById(id);
    }

    @Override
    public List<PetDTO> listAll(){

        return petRepository.findAll()
                .stream()
                .map(PetDTO::fromEntity)
                .toList();
    }

    @Override
    public List<PetDTO> listByName(String name){

        return petRepository.findByName(name)
                .stream()
                .map(PetDTO::fromEntity)
                .toList();
    }

    @Override
    public List<PetDTO> listByNameContainingIgnoreCase(String name){

        return petRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(PetDTO::fromEntity)
                .toList();
        }

    @Override
    public List<PetDTO> listBySex(PetSex sex){

        return petRepository.findBySexPet(sex)
                .stream()
                .map(PetDTO::fromEntity)
                .toList();
    }

    @Override
    public List<PetDTO> listByType(PetType type){


        return petRepository.findByTypePet(type)
                .stream()
                .map(PetDTO::fromEntity)
                .toList();
    }


}
