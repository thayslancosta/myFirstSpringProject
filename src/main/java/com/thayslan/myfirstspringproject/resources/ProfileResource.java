package com.thayslan.myfirstspringproject.resources;

import com.thayslan.myfirstspringproject.entities.Product;
import com.thayslan.myfirstspringproject.entities.Profile;
import com.thayslan.myfirstspringproject.repositories.ProductRepository;
import com.thayslan.myfirstspringproject.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/profiles")
public class ProfileResource {


    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping
    public ResponseEntity<List<Profile>> findAll() {
		List<Profile> profile = profileRepository.findAll();
        return ResponseEntity.ok().body(profile);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Profile>findById(@PathVariable Long id) {
		Profile profile = profileRepository.findById(id).get();
        return ResponseEntity.ok().body(profile);
    }
}