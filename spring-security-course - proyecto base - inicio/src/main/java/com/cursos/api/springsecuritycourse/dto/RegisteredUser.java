package com.cursos.api.springsecuritycourse.dto;
import java.io.Serializable;

public class RegisteredUser implements Serializable {
    
    private Long id;
    private String username;
    private String name;
    private String role;
    private String jwt;
}
