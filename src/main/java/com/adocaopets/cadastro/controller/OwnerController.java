package com.adocaopets.cadastro.controller;

import com.adocaopets.cadastro.service.PetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "owner")
public class OwnerController {

    private PetService petService;
}
