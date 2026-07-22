package com.store.infinity.controller;

import com.store.infinity.model.Product;
import com.store.infinity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
