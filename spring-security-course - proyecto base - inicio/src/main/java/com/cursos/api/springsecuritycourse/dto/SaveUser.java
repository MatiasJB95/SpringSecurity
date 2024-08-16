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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
