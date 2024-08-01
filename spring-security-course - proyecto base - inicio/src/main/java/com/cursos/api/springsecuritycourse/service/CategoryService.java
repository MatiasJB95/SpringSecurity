package com.cursos.api.springsecuritycourse.service;

import com.cursos.api.springsecuritycourse.persistence.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {

    Page<Category> findAll(Pageable pageable);


    Optional<Category> findByOneId(Long categoryId);
    
}
