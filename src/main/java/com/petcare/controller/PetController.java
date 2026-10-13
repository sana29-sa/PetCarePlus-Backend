
package com.petcare.controller;

import com.petcare.model.Pet;
import com.petcare.repository.PetRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetRepository repo;

    public PetController(PetRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Pet> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Pet one(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Pet not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet create(@Valid @RequestBody Pet p) {
        p.setId(null);
        return repo.save(p);
    }

    @PutMapping("/{id}")
    public Pet update(@PathVariable Long id, @Valid @RequestBody Pet x) {
        Pet p = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Pet not found"));

        p.setName(x.getName());
        p.setSpecies(x.getSpecies());
        p.setBreed(x.getBreed());
        p.setGender(x.getGender());
        p.setBirthDate(x.getBirthDate());
        p.setWeightKg(x.getWeightKg());
        p.setPhotoUrl(x.getPhotoUrl());
        p.setAllergies(x.getAllergies());
        p.setNotes(x.getNotes());

        return repo.save(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Pet not found");
        }
        repo.deleteById(id);
    }
}
