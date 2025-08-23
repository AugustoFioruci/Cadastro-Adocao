package com.adocaopets.cadastro.service;
import com.adocaopets.cadastro.model.*;
import com.adocaopets.cadastro.repository.OwnerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OwnerServiceImpl{

    private OwnerRepository ownerRepository;

    Owner createOwner(Owner owner){
        return ownerRepository.save(owner);
    }

    Owner updateOwner(Long id, Owner ownerUpdate){
        Owner owner = ownerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Dono não encontrado"));
        owner.setName(ownerUpdate.getName());
        owner.setCpf(ownerUpdate.getCpf());
        owner.setTelephoneNumber(ownerUpdate.getTelephoneNumber());

        if (ownerUpdate.getAddress() != null) {
            owner.setAddress(ownerUpdate.getAddress());
        }
        return ownerRepository.save(owner);
    }

    void deleteOwner(Long id){
        ownerRepository.deleteById(id);
    }

    List<Owner> listAll(){
        return ownerRepository.findAll();
    }

    List<Owner> listByName(String name){
        return ownerRepository.findByName(name);
    }

    List<Owner> listByNameContainingIgnoreCase(String name){
        return  ownerRepository.findByNameContainingIgnoringCase(name);
    }

    List<Owner> listByCpf(String cpf){
        return ownerRepository.findByCpf(cpf);
    }
}
