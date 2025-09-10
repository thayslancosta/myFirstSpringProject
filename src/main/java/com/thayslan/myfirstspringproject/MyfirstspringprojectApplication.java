package com.thayslan.myfirstspringproject;

import com.thayslan.myfirstspringproject.entities.Category;
import com.thayslan.myfirstspringproject.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@CommandLineRunner é uma interface que executa um código automaticamente
// logo após a inicialização da aplicação Spring Boot.
public class MyfirstspringprojectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MyfirstspringprojectApplication.class, args);
	}

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(1L, "Electronics");
		Category cat2 = new Category(2L, "Books");

		categoryRepository.save(cat1);
		categoryRepository.save(cat2);
	}
}
