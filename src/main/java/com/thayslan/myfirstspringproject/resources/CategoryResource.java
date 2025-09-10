package com.thayslan.myfirstspringproject.resources;

import com.thayslan.myfirstspringproject.entities.Category;
import com.thayslan.myfirstspringproject.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		Category cat = categoryRepository.findById(id);
        return ResponseEntity.ok().body(cat);
    }
}