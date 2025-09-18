package com.thayslan.myfirstspringproject.resources;

import com.thayslan.myfirstspringproject.entities.Client;
import com.thayslan.myfirstspringproject.entities.Product;
import com.thayslan.myfirstspringproject.entities.Profile;
import com.thayslan.myfirstspringproject.repositories.ProductRepository;
import com.thayslan.myfirstspringproject.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseEntity<Profile> create(@RequestBody Profile profile) {
        Profile savedProfile= profileRepository.save(profile);
        return ResponseEntity.ok(savedProfile);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> update(@PathVariable Long id, @RequestBody Profile profile) {
        profile.setId(id);
        Profile updatedProfile = profileRepository.save(profile);
        return ResponseEntity.ok(updatedProfile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        profileRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}