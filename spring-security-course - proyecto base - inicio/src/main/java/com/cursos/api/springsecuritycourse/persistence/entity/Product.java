package com.cursos.api.springsecuritycourse.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    public static enum ProductStatus {
        ENABLE, DISABLE;
    }
}
