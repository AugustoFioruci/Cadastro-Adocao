package com.adocaopets.cadastro.controller;

import com.adocaopets.cadastro.dto.OwnerDTO;
import com.adocaopets.cadastro.request.OwnerRequest;
import com.adocaopets.cadastro.service.OwnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;


    @PostMapping
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody @Valid OwnerRequest request){
        OwnerDTO owner = ownerService.createOwner(request);
        return ResponseEntity.created(URI.create("/owners/"+owner.getId())).body(owner);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<OwnerDTO> updateOwner(@PathVariable Long id, @RequestBody @Valid OwnerRequest request){
        OwnerDTO update = ownerService.updateOwner(id, request);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id){
        ownerService.deleteOwner(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<OwnerDTO>> listAll(){
        return ResponseEntity.ok(ownerService.listAll());
    }

    @GetMapping("/name")
    public ResponseEntity<List<OwnerDTO>> listByName(@RequestParam String name){
        return ResponseEntity.ok(ownerService.listByName(name));
    }

    @GetMapping("/name/contains")
    public ResponseEntity<List<OwnerDTO>> listByNameContainingIgnoreCase(@RequestParam String name){
        return ResponseEntity.ok(ownerService.listByNameContainingIgnoreCase(name));
    }

    @GetMapping("/cpf")
    public ResponseEntity<List<OwnerDTO>> listByCpf(@RequestParam String cpf){
        return ResponseEntity.ok(ownerService.listByCpf(cpf));
    }
}
