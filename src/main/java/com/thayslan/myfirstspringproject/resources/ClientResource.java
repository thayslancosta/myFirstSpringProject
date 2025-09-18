package com.thayslan.myfirstspringproject.resources;

import com.thayslan.myfirstspringproject.entities.Category;
import com.thayslan.myfirstspringproject.entities.Client;
import com.thayslan.myfirstspringproject.repositories.CategoryRepository;
import com.thayslan.myfirstspringproject.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    private ClientRepository clientRepository;


    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
		List<Client> clients = clientRepository.findAll();
        return ResponseEntity.ok().body(clients);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client>findById(@PathVariable Long id) {
		Client client = clientRepository.findById(id).get();
        return ResponseEntity.ok().body(client);
    }
}