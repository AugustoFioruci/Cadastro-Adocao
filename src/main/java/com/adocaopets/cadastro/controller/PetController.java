package com.adocaopets.cadastro.controller;

import com.adocaopets.cadastro.model.entity.Pet;
import com.adocaopets.cadastro.model.enums.PetType;
import com.adocaopets.cadastro.model.enums.SexPet;
import com.adocaopets.cadastro.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet){
        Pet created = petService.createPet(pet);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pet> updatePet(@PathVariable Long id,@RequestBody Pet pet){
        Pet updated = petService.updatePet(id, pet);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id){
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Pet>> listAll(){
        return ResponseEntity.ok(petService.listAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Pet>> listByName(@RequestParam String name){
        return ResponseEntity.ok(petService.listByName(name));
    }
    @GetMapping("/search")
    public ResponseEntity<List<Pet>> listByNameContainingIgnoreCase(@RequestParam String name){
        return ResponseEntity.ok(petService.listByNameContainingIgnoreCase(name));
    }

    @GetMapping("/type")
    public ResponseEntity<List<Pet>> listByType(@RequestParam PetType type){
        return ResponseEntity.ok(petService.listByType(type));
    }

    @GetMapping("/sex")
    public ResponseEntity<List<Pet>> listBySex(@RequestParam SexPet sex){
        return ResponseEntity.ok(petService.listBySex(sex));
    }
}
