package com.cursos.api.springsecuritycourse.service;

import com.cursos.api.springsecuritycourse.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Optional<Product> findByOneId(Long productId);
}
