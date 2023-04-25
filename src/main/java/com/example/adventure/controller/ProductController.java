package com.example.adventure.controller;

import com.example.adventure.model.Product;
import com.example.adventure.repository.ProductRepository;
import com.example.adventure.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ResponseBody
@RestController("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> findAll() {
        List<Product> products = productService.findAll();
        return products;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> find(@PathVariable int id) throws Exception {
        Optional<Product> product = productService.findById(id);
        if (product.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product.get());
    }

    @PostMapping()
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (productService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/inventory")
    public ProductService.Inventory getInventory() {
        return this.productService.getProductsData();
    }
}