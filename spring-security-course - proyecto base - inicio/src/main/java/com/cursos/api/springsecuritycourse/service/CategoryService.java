package com.cursos.api.springsecuritycourse.service;

import com.cursos.api.springsecuritycourse.dto.SaveCategory;
import com.cursos.api.springsecuritycourse.persistence.entity.Category;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {

    Page<Category> findAll(Pageable pageable);


    Optional<Category> findByOneId(Long categoryId);

    Category createOn(@Valid SaveCategory saveCategory);

    Category updateOneById(Long categoryId, SaveCategory saveCategory);

    Category disableOneById(Long categoryId);
    
}
