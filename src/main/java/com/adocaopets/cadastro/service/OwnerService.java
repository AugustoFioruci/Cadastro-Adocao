package com.adocaopets.cadastro.service;
import com.adocaopets.cadastro.model.*;
import java.util.List;

public interface OwnerService {
    Owner createOwner(Owner owner);
    Owner updateOwner(Long id, Owner ownerUpdate);
    void deleteOwner(Long id);
    List<Owner> listAll();
    List<Owner> listByName(String name);
    List<Owner> listByNameContainingIgnoreCase(String name);
    List<Owner> listByCpf(String cpf);
}
