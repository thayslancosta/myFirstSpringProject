package com.thayslan.myfirstspringproject.resources;

import com.thayslan.myfirstspringproject.entities.Category;
import com.thayslan.myfirstspringproject.entities.Product;
import com.thayslan.myfirstspringproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/products")
public class ProductResource {


    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
		List<Product> list = productRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product>findById(@PathVariable Long id) {
		Product product = productRepository.findById(id).get();
        return ResponseEntity.ok().body(product);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.ok(savedProduct );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}