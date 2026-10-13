
package com.petcare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reminders")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @NotBlank
    @Column(nullable = false)
    private String type;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate dueDate;

    private LocalTime dueTime;

    @Column(nullable = false)
    private boolean completed = false;

    @Column(length = 1000)
    private String notes;

    public Reminder() {}

    public Long getId() { return id; }
    public void setId(Long v) { id = v; }

    public Pet getPet() { return pet; }
    public void setPet(Pet v) { pet = v; }

    public String getType() { return type; }
    public void setType(String v) { type = v; }

    public String getTitle() { return title; }
    public void setTitle(String v) { title = v; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate v) { dueDate = v; }

    public LocalTime getDueTime() { return dueTime; }
    public void setDueTime(LocalTime v) { dueTime = v; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean v) { completed = v; }

    public String getNotes() { return notes; }
    public void setNotes(String v) { notes = v; }
}
