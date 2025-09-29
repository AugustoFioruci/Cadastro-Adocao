package com.adocaopets.cadastro.controller;

import com.adocaopets.cadastro.dto.AdoptionDTO;
import com.adocaopets.cadastro.request.AdoptionRequest;
import com.adocaopets.cadastro.service.AdoptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/adoptions")
public class AdoptionController {

    private final AdoptionService adoptionService;

    @PostMapping
    public ResponseEntity<AdoptionDTO> createAdoption(@RequestBody @Valid AdoptionRequest request){
        AdoptionDTO adoption = adoptionService.createAdoption(request);
        return ResponseEntity.created(URI.create("/adoptions/"+adoption.getId())).body(adoption);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AdoptionDTO> updateAdoption(@RequestBody @Valid AdoptionRequest request,
                                                      @PathVariable Long id){
        AdoptionDTO adoption = adoptionService.updateAdoption(request, id);
        return ResponseEntity.ok(adoption);
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<AdoptionDTO> cancelAdoption(@PathVariable Long id){
        AdoptionDTO adoption = adoptionService.cancelAdoption(id);
        return ResponseEntity.ok(adoption);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdoptionDTO> listById(@PathVariable Long id){
        return ResponseEntity.ok(adoptionService.listById(id));
    }

    @GetMapping
    public ResponseEntity<List<AdoptionDTO>> listAll(){
        return ResponseEntity.ok(adoptionService.listAll());
    }

    @GetMapping("/pets")
    public ResponseEntity<List<AdoptionDTO>> listByPetId(@RequestParam Long id){
        return ResponseEntity.ok(adoptionService.listByPetId(id));
    }

    @GetMapping("/owners")
    public ResponseEntity<List<AdoptionDTO>> listByOwnerCpf(@RequestParam String cpf){
        return ResponseEntity.ok(adoptionService.listByOwnerCpf(cpf));
    }

    @GetMapping("/owners/{cpf}/pets/{id}")
    public ResponseEntity<List<AdoptionDTO>> listAdoptionByPetIdAndOwnerCpf(@PathVariable Long id,
                                                                            @PathVariable String cpf){
        return ResponseEntity.ok(adoptionService.listAdoptionByPetIdAndOwnerCpf(id,cpf));
    }




}
