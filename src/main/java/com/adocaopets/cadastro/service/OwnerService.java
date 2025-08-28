package com.adocaopets.cadastro.service;
import com.adocaopets.cadastro.dto.OwnerDTO;
import com.adocaopets.cadastro.model.entity.Owner;
import com.adocaopets.cadastro.request.OwnerRequest;

import java.util.List;

public interface OwnerService {
    OwnerDTO createOwner(OwnerRequest request);
    OwnerDTO updateOwner(Long id, OwnerRequest request);
    void deleteOwner(Long id);
    List<OwnerDTO> listAll();
    List<OwnerDTO> listByName(String name);
    List<OwnerDTO> listByNameContainingIgnoreCase(String name);
    List<OwnerDTO> listByCpf(String cpf);
}
