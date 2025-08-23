package com.adocaopets.cadastro.service.impl;
import com.adocaopets.cadastro.model.enity.Owner;
import com.adocaopets.cadastro.repository.OwnerRepository;
import com.adocaopets.cadastro.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    public Owner createOwner(Owner owner){
        return ownerRepository.save(owner);
    }

    @Override
    public Owner updateOwner(Long id, Owner ownerUpdate){
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

    @Override
    public void deleteOwner(Long id){
        ownerRepository.deleteById(id);
    }

    @Override
    public List<Owner> listAll(){
        return ownerRepository.findAll();
    }

    @Override
    public List<Owner> listByName(String name){
        return ownerRepository.findByName(name);
    }

    @Override
    public List<Owner> listByNameContainingIgnoreCase(String name){
        return  ownerRepository.findByNameContainingIgnoringCase(name);
    }

    @Override
    public List<Owner> listByCpf(String cpf){
        return ownerRepository.findByCpf(cpf);
    }
}
