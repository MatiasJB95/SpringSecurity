package com.cursos.api.springsecuritycourse.service.impl;

import com.cursos.api.springsecuritycourse.dto.SaveCategory;
import com.cursos.api.springsecuritycourse.persistence.entity.Category;
import com.cursos.api.springsecuritycourse.persistence.repository.CategoryRepository;
import com.cursos.api.springsecuritycourse.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Optional<Category> findByOneId(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public Category createOn(SaveCategory saveCategory) {
        return null;
    }

    @Override
    public Category updateOneById(Long categoryId, SaveCategory saveCategory) {
        return null;
    }

    @Override
    public Category disableOneById(Long categoryId) {
        return null;
    }
}
