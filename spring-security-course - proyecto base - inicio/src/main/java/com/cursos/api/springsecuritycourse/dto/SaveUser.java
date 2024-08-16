package com.cursos.api.springsecuritycourse.dto;

import java.io.Serializable;

import org.springframework.security.web.firewall.StrictHttpFirewall;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SaveUser implements Serializable {
    @Size(min=4)
    private String name;
    @Size(min=4)
    private String username;
    @Size(min=8)
    private String password;
    @Size(min=8)
    private String repeatPassword;
}
