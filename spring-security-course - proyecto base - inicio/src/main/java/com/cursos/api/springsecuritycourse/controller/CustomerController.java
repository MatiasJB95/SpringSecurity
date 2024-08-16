package com.cursos.api.springsecuritycourse.controller;

import com.cursos.api.springsecuritycourse.dto.SaveUser;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.cursos.api.springsecuritycourse.service.auth.AuthenticationService;
import com.cursos.api.springsecuritycourse.dto.RegisteredUser;


@RestController
@RequestMapping("/Customers")
public class CustomerController {
    @Autowired
    private AuthenticationService authenticateService;

    @PostMapping()
    public ResponseEntity<RegisteredUser> registerOne(@RequestBody @Valid SaveUser newUser) {
        RegisteredUser registeredUser = (RegisteredUser) authenticateService.registerOneCustomer(newUser);

            return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }
    
}