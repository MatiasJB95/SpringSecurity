package com.cursos.api.springsecuritycourse.controller;

import com.cursos.api.springsecuritycourse.dto.SaveCategory;
import com.cursos.api.springsecuritycourse.dto.SaveProduct;
import com.cursos.api.springsecuritycourse.persistence.entity.Category;
import com.cursos.api.springsecuritycourse.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<Category>>findAll(Pageable pageable){
        Page<Category> categotyPrage =categoryService.findAll(pageable);
        if (categotyPrage.hasContent()){
            return ResponseEntity.ok(categotyPrage);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category>findOneById(@PathVariable Long categoryId){
        Optional<Category> category = categoryService.findByOneId(categoryId);
        if (category.isPresent()){
            return ResponseEntity.ok(category.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Category>createOnById(@RequestBody @Valid SaveCategory saveCategory){
        Category category = categoryService.createOn(saveCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }
    @PutMapping("/{categoryId}")
    public ResponseEntity<Category>updateOneById(@PathVariable Long categoryId, @RequestBody @Valid SaveCategory saveCategory){
        Category category = categoryService.updateOneById(categoryId, saveCategory);
        return ResponseEntity.ok(category);
    }
    @PutMapping ("/{productId}/disable")
    public ResponseEntity<Category>disableOneById(@PathVariable Long productId){
        Category product = categoryService.disableOneById(productId);
        return ResponseEntity.ok(product);
    }
}
