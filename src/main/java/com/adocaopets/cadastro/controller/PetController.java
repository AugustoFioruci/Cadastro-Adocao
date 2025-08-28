package com.adocaopets.cadastro.controller;

import com.adocaopets.cadastro.dto.PetDTO;
import com.adocaopets.cadastro.model.entity.Pet;
import com.adocaopets.cadastro.model.enums.PetType;
import com.adocaopets.cadastro.model.enums.PetSex;
import com.adocaopets.cadastro.request.PetRequest;
import com.adocaopets.cadastro.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    @PostMapping
    public ResponseEntity<PetDTO> createPet(@RequestBody @Valid PetRequest request){
        PetDTO pet = petService.createPet(request);
        return ResponseEntity.created(URI.create("/pets/"+pet.getId())).body(pet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDTO> updatePet(@PathVariable Long id,@RequestBody @Valid PetRequest request){
        PetDTO petUpdate = petService.updatePet(id, request);
        return ResponseEntity.ok(petUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id){
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PetDTO>> listAll(){
        return ResponseEntity.ok(petService.listAll());
    }

    @GetMapping("/name")
    public ResponseEntity<List<PetDTO>> listByName(@RequestParam String name){
        return ResponseEntity.ok(petService.listByName(name));
    }
    @GetMapping("/name/contains")
    public ResponseEntity<List<PetDTO>> listByNameContainingIgnoreCase(@RequestParam String name){
        return ResponseEntity.ok(petService.listByNameContainingIgnoreCase(name));
    }

    @GetMapping("/type")
    public ResponseEntity<List<PetDTO>> listByType(@RequestParam PetType type){
        return ResponseEntity.ok(petService.listByType(type));
    }

    @GetMapping("/sex")
    public ResponseEntity<List<PetDTO>> listBySex(@RequestParam PetSex sex){
        return ResponseEntity.ok(petService.listBySex(sex));
    }
}
