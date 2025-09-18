package com.thayslan.myfirstspringproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Anottation para ele não serializar essa lista
    // iria ficar em um loop infinito por causa da referência categoria tem uma lista de produtos e produto tem uma categoria
    //Serve para dizer ao Spring “não inclua este campo quando transformar o objeto em JSON”.
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id != null && id.equals(category.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
