package com.adocaopets.cadastro.service.impl;
import com.adocaopets.cadastro.dto.OwnerDTO;
import com.adocaopets.cadastro.model.entity.Address;
import com.adocaopets.cadastro.model.entity.Owner;
import com.adocaopets.cadastro.repository.OwnerRepository;
import com.adocaopets.cadastro.request.OwnerRequest;
import com.adocaopets.cadastro.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    public OwnerDTO createOwner(OwnerRequest request){

        Owner owner = Owner.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .telephoneNumber(request.getTelephoneNumber())
                .address(Address.builder()
                        .city(request.getAddress().getCity())
                        .street(request.getAddress().getStreet())
                        .number(request.getAddress().getNumber())
                        .neighborhood(request.getAddress().getNeighborhood())
                        .build())
                .build();

        Owner saved = ownerRepository.save(owner);

        return OwnerDTO.fromEntity(saved);
    }

    @Override
    public OwnerDTO updateOwner(Long id, OwnerRequest request){


        Owner owner = ownerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Dono não encontrado"));

        owner.setName(request.getName());
        owner.setCpf(request.getCpf());
        owner.setTelephoneNumber(request.getTelephoneNumber());
        owner.getAddress().setCity(request.getAddress().getCity());
        owner.getAddress().setNeighborhood(request.getAddress().getNeighborhood());
        owner.getAddress().setStreet(request.getAddress().getStreet());
        owner.getAddress().setNumber(request.getAddress().getNumber());

        Owner saved = ownerRepository.save(owner);

        return OwnerDTO.fromEntity(saved);
    }

    @Override
    public void deleteOwner(Long id){

        Owner owner = ownerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Dono não encontrado"));

        ownerRepository.deleteById(id);
    }

    @Override
    public OwnerDTO listById(Long id){
        return ownerRepository.findById(id)
                .map(OwnerDTO::fromEntity)
                .orElseThrow(() -> new RuntimeException("Dono não encontrado"));
    }

    @Override
    public List<OwnerDTO> listAll(){


        return ownerRepository.findAll()
                .stream()
                .map(OwnerDTO::fromEntity)
                .toList();
    }

    @Override
    public List<OwnerDTO> listByName(String name){

        return ownerRepository.findByName(name)
                .stream()
                .map(OwnerDTO::fromEntity)
                .toList();
    }

    @Override
    public List<OwnerDTO> listByNameContainingIgnoreCase(String name){
        return  ownerRepository.findByNameContainingIgnoringCase(name)
                .stream()
                .map(OwnerDTO::fromEntity)
                .toList();
    }

    @Override
    public List<OwnerDTO> listByCpf(String cpf){
        return ownerRepository.findByCpf(cpf)
                .stream()
                .map(OwnerDTO::fromEntity)
                .toList();
    }
}
