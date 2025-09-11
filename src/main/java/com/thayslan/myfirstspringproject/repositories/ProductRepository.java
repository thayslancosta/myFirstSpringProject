package com.thayslan.myfirstspringproject.repositories;


import com.thayslan.myfirstspringproject.entities.Category;
import com.thayslan.myfirstspringproject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {
}













/*import com.thayslan.myfirstspringproject.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;*/
/*
//“Essa classe é um bean gerenciado pelo Spring
// ou seja, o Spring vai criar e controlar uma instância dela para mim.”
@Component
public class ProductRepository {

    private Map<Long, Product> map = new HashMap<>();

    public void save(Product obj) {
		map.put(obj.getId(), obj);
    }

    public Product findById(Long id) {
		return map.get(id);
    }

    public List<Product> findAll() {
		return new ArrayList<>(map.values());
    }
}*/
