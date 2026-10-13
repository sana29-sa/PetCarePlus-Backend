
package com.petcare.controller;

import com.petcare.model.*;
import com.petcare.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/records")
public class CareRecordController {
    private final CareRecordRepository records;
    private final PetRepository pets;

    public CareRecordController(CareRecordRepository r, PetRepository p) {
        records = r;
        pets = p;
    }

    @GetMapping
    public List<CareRecord> all(@RequestParam(required = false) Long petId) {
        return petId == null
                ? records.findAll()
                : records.findByPetIdOrderByRecordDateDesc(petId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CareRecord create(@RequestBody RecordRequest x) {
        Pet p = pets.findById(x.petId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Pet not found"));

        CareRecord r = new CareRecord();
        r.setPet(p);
        r.setCategory(x.category());
        r.setTitle(x.title());
        r.setRecordDate(x.recordDate());
        r.setNextDueDate(x.nextDueDate());
        r.setAmount(x.amount());
        r.setUnit(x.unit());
        r.setNotes(x.notes());

        return records.save(r);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!records.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Record not found");
        }
        records.deleteById(id);
    }

    public record RecordRequest(
            Long petId,
            String category,
            String title,
            LocalDate recordDate,
            LocalDate nextDueDate,
            Double amount,
            String unit,
            String notes) {}
}
