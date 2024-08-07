package com.cursos.api.springsecuritycourse.service.impl;

import com.cursos.api.springsecuritycourse.dto.SaveProduct;
import com.cursos.api.springsecuritycourse.exception.ObjectNotFoundException;
import com.cursos.api.springsecuritycourse.persistence.entity.Category;
import com.cursos.api.springsecuritycourse.persistence.entity.Product;
import com.cursos.api.springsecuritycourse.persistence.repository.ProductRepository;
import com.cursos.api.springsecuritycourse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findByOneId(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product createOn(SaveProduct saveProduct) {
        Product product = new Product();
        product.setName(saveProduct.getName());
        product.setPrice(saveProduct.getPrice());
        product.setStatus(Product.ProductStatus.ENABLED);

        Category category = new Category();
        category.setId(saveProduct.getCategoryId());
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public Product updatOneById(Long productId, SaveProduct saveProduct) {
        Product productFromDB = productRepository.findById(productId)
                        .orElseThrow(()-> new ObjectNotFoundException("Product not found by Id" +productId));
        productFromDB.setName(saveProduct.getName());
        productFromDB.setPrice(saveProduct.getPrice());
        Category category = new Category();
        category.setId(saveProduct.getCategoryId());
        productFromDB.setCategory(category);

        return productRepository.save(productFromDB);
    }

    @Override
    public Product disableOneById(Long productId) {
        Product productFromDB = productRepository.findById(productId)
                .orElseThrow(()-> new ObjectNotFoundException("Product not found by Id" +productId));
        productFromDB.setStatus(Product.ProductStatus.DISABLED);
        return productRepository.save(productFromDB);
    }

    @Override
    public Product enabledOneById(Long productId) {
        Product productFromDB = productRepository.findById(productId)
                .orElseThrow(() -> new ObjectNotFoundException("Product not found by id" +productId));
        productFromDB.setStatus(Product.ProductStatus.ENABLED);
        return productRepository.save(productFromDB);
    }

}
