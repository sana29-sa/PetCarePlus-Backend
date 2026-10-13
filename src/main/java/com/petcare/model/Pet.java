
package com.petcare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String species;

    private String breed;
    private String gender;
    private LocalDate birthDate;
    private Double weightKg;
    private String photoUrl;
    private String allergies;

    @Column(length = 1000)
    private String notes;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Pet() {}

    public Long getId() { return id; }
    public void setId(Long v) { id = v; }

    public String getName() { return name; }
    public void setName(String v) { name = v; }

    public String getSpecies() { return species; }
    public void setSpecies(String v) { species = v; }

    public String getBreed() { return breed; }
    public void setBreed(String v) { breed = v; }

    public String getGender() { return gender; }
    public void setGender(String v) { gender = v; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate v) { birthDate = v; }

    public Double getWeightKg() { return weightKg; }
    public void setWeightKg(Double v) { weightKg = v; }

    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String v) { photoUrl = v; }

    public String getAllergies() { return allergies; }
    public void setAllergies(String v) { allergies = v; }

    public String getNotes() { return notes; }
    public void setNotes(String v) { notes = v; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime v) { createdAt = v; }
}
