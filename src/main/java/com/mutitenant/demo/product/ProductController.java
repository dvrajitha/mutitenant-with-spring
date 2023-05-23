package com.mutitenant.demo.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    List<Product> products() {
        return productRepository.findAll();
    }

    @PostMapping
    Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
