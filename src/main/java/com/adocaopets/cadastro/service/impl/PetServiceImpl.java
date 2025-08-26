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
                .address(request.getAddress())
                .typePet(request.getTypePet())
                .sexPet(request.getSexPet())
                .birthDate(request.getBirthDate())
                .weightInGrams(request.getWeightInGrams())
                .race(request.getRace())
                .build();

        Pet savedPet = petRepository.save(pet);

        return PetDTO.builder()
                .id(savedPet.getId())
                .name(savedPet.getName())
                .address(savedPet.getAddress())
                .birthDate(savedPet.getBirthDate())
                .weightInGrams(savedPet.getWeightInGrams())
                .race(savedPet.getRace())
                .typePet(savedPet.getTypePet())
                .sexPet(savedPet.getSexPet())
                .build();

    }

    @Override
    public Pet updatePet(Long id, Pet petUpdated){

            Pet pet = petRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Animal não encontrado Id:"+id));

            pet.setName(petUpdated.getName());
            pet.setAddress(petUpdated.getAddress());
            pet.setBirthDate(petUpdated.getBirthDate());
            pet.setWeightInGrams(petUpdated.getWeightInGrams());
            pet.setRace(petUpdated.getRace());
            pet.setTypePet(petUpdated.getTypePet());
            pet.setSexPet(petUpdated.getSexPet());
            return petRepository.save(pet);

    }

    @Override
    public void deletePet(Long id){
        petRepository.deleteById(id);
    }

    @Override
    public List<Pet> listAll(){
        return petRepository.findAll();
    }

    @Override
    public List<Pet> listByName(String name){
        return petRepository.findByName(name);
    }

    @Override
    public List<Pet> listByNameContainingIgnoreCase(String name){ return petRepository.findByNameContainingIgnoreCase(name);}

    @Override
    public List<Pet> listBySex(PetSex sex){
        return petRepository.findBySexPet(sex);
    }

    @Override
    public List<Pet> listByType(PetType type){
        return petRepository.findByTypePet(type);
    }


}
