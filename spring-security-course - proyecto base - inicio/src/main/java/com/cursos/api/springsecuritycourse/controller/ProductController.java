package com.cursos.api.springsecuritycourse.controller;

import com.cursos.api.springsecuritycourse.persistence.entity.Product;
import com.cursos.api.springsecuritycourse.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>>findAll(Pageable pageable){
        Page<Product> productPage =productService.findAll(pageable);
        if (productPage.hasContent()){
            return ResponseEntity.ok(productPage);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product>findOneById(@PathVariable Long productId){
        Optional<Product> product = productService.findByOneId(productId);
        if (product.isPresent()){
            return ResponseEntity.ok(product.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping ("/{productId}")
    public ResponseEntity<Product>Create(@RequestBody @Valid SaveProduct saveProduct){
        
    }
}
