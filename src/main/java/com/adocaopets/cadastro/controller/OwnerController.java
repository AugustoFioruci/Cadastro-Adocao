package com.adocaopets.cadastro.controller;

import com.adocaopets.cadastro.service.OwnerService;
import com.adocaopets.cadastro.model.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "owner")
public class OwnerController {

    private OwnerService ownerService;


    @PostMapping
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner){
        return ResponseEntity.ok(owner);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Owner> updateOwner(@PathVariable Long id, @RequestBody Owner owner){
        Owner update = ownerService.updateOwner(id, owner);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id){
        ownerService.deleteOwner(id);
        return ResponseEntity.noContent().build();
    }
}
