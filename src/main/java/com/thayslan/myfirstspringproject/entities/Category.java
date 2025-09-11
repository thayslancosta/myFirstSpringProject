package com.thayslan.myfirstspringproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    // Anottation para ele não serializar essa lista
    // iria ficar em um loop infinito por causa da referência categoria tem uma lista de produtos e produto tem uma categoria
    //Serve para dizer ao Spring “não inclua este campo quando transformar o objeto em JSON”.
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    public Category() {

    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
