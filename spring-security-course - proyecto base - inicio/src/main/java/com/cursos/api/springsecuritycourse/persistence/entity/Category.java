package com.cursos.api.springsecuritycourse.persistence.entity;

import jakarta.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryStatus status;

    public static enum CategoryStatus{
        ENABLE, DISABLED;
    }
}
