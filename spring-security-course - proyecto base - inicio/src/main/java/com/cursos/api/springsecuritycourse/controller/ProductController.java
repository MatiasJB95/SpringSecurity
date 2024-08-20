package com.cursos.api.springsecuritycourse.controller;

import com.cursos.api.springsecuritycourse.dto.SaveProduct;
import com.cursos.api.springsecuritycourse.persistence.entity.Product;
import com.cursos.api.springsecuritycourse.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
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
    @PostMapping
    public ResponseEntity<Product>createOn(@RequestBody @Valid SaveProduct saveProduct){
        Product product = productService.createOn(saveProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
        //JPÁ nunca devuelve null
    }
    @PutMapping ("/{productId}")
    public ResponseEntity<Product>updateOneById(@PathVariable Long productId ,
                                                @RequestBody @Valid SaveProduct saveProduct){
        Product product = productService.updatOneById(productId, saveProduct);
        return ResponseEntity.ok(product);
    }
    @PutMapping ("/{productId}/disable")
    public ResponseEntity<Product>disableOneById(@PathVariable Long productId){
        Product product = productService.disableOneById(productId);
        return ResponseEntity.ok(product);
    }
    @PutMapping ("/{productId}/enabled")
    public ResponseEntity<Product>enabledOneById(@PathVariable Long productId){
        Product product = productService.enabledOneById(productId);
        return ResponseEntity.ok(product);
    }
    8}
}
