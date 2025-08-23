package com.adocaopets.cadastro.service;
import com.adocaopets.cadastro.model.*;
import java.util.List;

public interface OwnerService {
    Owner createOwner(Owner owner);
    Owner updateOwner(Long id);
    void deleteOwner(Long id);
    List<Owner> listAll();
}
