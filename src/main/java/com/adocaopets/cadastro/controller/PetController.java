package com.adocaopets.cadastro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    @GetMapping("/Ola")
    public String hello(){
        return "Olá Mundo";
    }

}
