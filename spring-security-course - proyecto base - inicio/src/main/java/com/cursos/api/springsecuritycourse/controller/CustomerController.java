package com.cursos.api.springsecuritycourse.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/Customers")
public class CustomerController {

    @PostMapping()
    public ResponseEntity <RegisteredUser> registerOne(@RequestBody @Valid
        SaveUser newUser) {
            RegisteredUser = authenticateService.registerOneCustomer(newUser);

 
    }
    
}