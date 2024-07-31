package com.cursos.api.springsecuritycourse.controller;

import com.cursos.api.springsecuritycourse.dto.SaveProduct;
import com.cursos.api.springsecuritycourse.persistence.entity.Category;
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

    @GetMapping("/{productId}")
    public ResponseEntity<Category>findOneById(@PathVariable Long productId){
        Optional<Category> product = categoryService.findByOneId(productId);
        if (product.isPresent()){
            return ResponseEntity.ok(product.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Category>createOn(@RequestBody @Valid SaveProduct saveProduct){
        Category product = categoryService.createOn(saveProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
        //JPÁ nunca devuelve null
    }
    @PutMapping ("/{productId}")
    public ResponseEntity<Category>updateOneById(@PathVariable Long productId ,
                                                @RequestBody @Valid SaveProduct saveProduct){
        Category product = categoryService.updatOneById(saveProduct);
        return ResponseEntity.ok(product);
    }
    @PutMapping ("/{productId}/disable")
    public ResponseEntity<Category>disableOneById(@PathVariable Long productId){
        Category product = categoryService.disableOneById(productId);
        return ResponseEntity.ok(product);
    }
}
