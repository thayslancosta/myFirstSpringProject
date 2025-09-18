package com.thayslan.myfirstspringproject.resources;

import com.thayslan.myfirstspringproject.entities.Category;
import com.thayslan.myfirstspringproject.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// @RestController define que essa classe será um recurso Rest
@RestController
// @RequestMapping define o caminho que ele deverá seguir
@RequestMapping(value = "/categories")
public class CategoryResource {

    //@Autowired O Spring já criou (e gerencia) um objeto de CategoryRepository
    // (porque ele tem a anotação @Component)
    // e vai injetar essa instância pronta na variável categoryRepository.
    @Autowired
    private CategoryRepository categoryRepository;

    //@GetMapping define que quando você chamar uma requisição Get nesse recurso, será chamado o método a seguir
    @GetMapping
    // ResponseEntity < O que vai retornar >
    public ResponseEntity<List<Category>> findAll() {
		List<Category> list = categoryRepository.findAll();

        //.ok() é um metodo que instancia uma resposta (de código 200 http) de que deu tudo certo
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category>findById(@PathVariable Long id) {
		Category cat = categoryRepository.findById(id).get();
        return ResponseEntity.ok().body(cat);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        Category savedCategory = categoryRepository.save(category);
        return ResponseEntity.ok(savedCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        Category updatedCategory = categoryRepository.save(category);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
