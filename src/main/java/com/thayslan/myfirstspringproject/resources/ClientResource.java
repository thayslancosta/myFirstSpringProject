package com.thayslan.myfirstspringproject.resources;

import com.thayslan.myfirstspringproject.entities.Category;
import com.thayslan.myfirstspringproject.entities.Client;
import com.thayslan.myfirstspringproject.entities.Product;
import com.thayslan.myfirstspringproject.repositories.CategoryRepository;
import com.thayslan.myfirstspringproject.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {
        Client savedClient= clientRepository.save(client);
        return ResponseEntity.ok(savedClient );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        client.setId(id);
        Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}