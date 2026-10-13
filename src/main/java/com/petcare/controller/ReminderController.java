
package com.petcare.controller;

import com.petcare.model.*;
import com.petcare.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    private final ReminderRepository reminders;
    private final PetRepository pets;

    public ReminderController(ReminderRepository r, PetRepository p) {
        reminders = r;
        pets = p;
    }

    @GetMapping
    public List<Reminder> all(@RequestParam(required = false) Long petId) {
        return petId == null
                ? reminders.findAllByOrderByDueDateAsc()
                : reminders.findByPetIdOrderByDueDateAsc(petId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reminder create(@RequestBody ReminderRequest x) {
        Pet p = pets.findById(x.petId()).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Pet not found"));

        Reminder r = new Reminder();
        r.setPet(p);
        r.setType(x.type());
        r.setTitle(x.title());
        r.setDueDate(x.dueDate());
        r.setDueTime(x.dueTime());
        r.setNotes(x.notes());

        return reminders.save(r);
    }

    @PatchMapping("/{id}/complete")
    public Reminder complete(@PathVariable Long id) {
        Reminder r = reminders.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Reminder not found"));

        r.setCompleted(true);
        return reminders.save(r);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!reminders.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Reminder not found");
        }
        reminders.deleteById(id);
    }

    public record ReminderRequest(
            Long petId,
            String type,
            String title,
            LocalDate dueDate,
            LocalTime dueTime,
            String notes) {}
}
