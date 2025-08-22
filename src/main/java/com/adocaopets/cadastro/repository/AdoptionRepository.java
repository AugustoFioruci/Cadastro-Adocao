package com.adocaopets.cadastro.repository;
import com.adocaopets.cadastro.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption,Long> {
    List<Owner> findByOwnerName(String name);
    List<Pet> findByPetName(String name);
}
