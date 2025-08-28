package com.adocaopets.cadastro.controller;

import com.adocaopets.cadastro.dto.OwnerDTO;
import com.adocaopets.cadastro.request.OwnerRequest;
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
    public ResponseEntity<OwnerDTO> updateOwner(@PathVariable Long id, @RequestBody OwnerRequest request){
        OwnerDTO update = ownerService.updateOwner(id, request);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id){
        ownerService.deleteOwner(id);
        return ResponseEntity.noContent().build();
    }
}
