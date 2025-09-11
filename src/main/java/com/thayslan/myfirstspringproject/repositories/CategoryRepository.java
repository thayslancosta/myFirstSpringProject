package com.thayslan.myfirstspringproject.repositories;


import com.thayslan.myfirstspringproject.entities.Category;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


// Essa versão é a final, vá para o fim do código para ver a implementação ANTES DO JPA


@Repository
public interface CategoryRepository extends JpaRepository <Category, Long> {
}



// A seguir a implementação feita a mão sem uso de interface
/*

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.thayslan.myfirstspringproject.entities.Category;
import org.springframework.stereotype.Component;

//“Essa classe é um bean gerenciado pelo Spring
// ou seja, o Spring vai criar e controlar uma instância dela para mim.”
@Component
public class CategoryRepository {

    private Map<Long, Category> map = new HashMap<>();

    public void save(Category obj) {
		map.put(obj.getId(), obj);
    }

    public Category findById(Long id) {
		return map.get(id);
    }

    public List<Category> findAll() {
		return new ArrayList<>(map.values());
    }
}
*/
