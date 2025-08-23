package com.adocaopets.cadastro.repository;

import java.util.List;

import com.adocaopets.cadastro.model.enity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    List<Owner> findByName(String name);
    List<Owner> findByNameContainingIgnoringCase(String name);
    List<Owner> findByCpf(String cpf);
}
