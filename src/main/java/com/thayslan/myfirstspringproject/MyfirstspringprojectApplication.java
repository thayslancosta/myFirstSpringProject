package com.thayslan.myfirstspringproject;

import com.thayslan.myfirstspringproject.entities.Category;
import com.thayslan.myfirstspringproject.entities.Product;
import com.thayslan.myfirstspringproject.repositories.CategoryRepository;
import com.thayslan.myfirstspringproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
//@CommandLineRunner é uma interface que executa um código automaticamente
// logo após a inicialização da aplicação Spring Boot.
public class MyfirstspringprojectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MyfirstspringprojectApplication.class, args);
	}

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");

		Product p1 = new Product(null, "TV", 2200.00, cat1);
		Product p2 = new Product(null, "Domain Driven Design", 120.00, cat2);
		Product p3 = new Product(null, "PS5", 2800.00, cat1);
		Product p4 = new Product(null, "Docker", 100.00, cat2);

		cat1.getProducts().addAll(Arrays.asList(p1, p3));
		cat2.getProducts().addAll(Arrays.asList(p2, p4));

		categoryRepository.save(cat1);
		categoryRepository.save(cat2);

		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		productRepository.save(p4);
		//1:15:47
	}
}
