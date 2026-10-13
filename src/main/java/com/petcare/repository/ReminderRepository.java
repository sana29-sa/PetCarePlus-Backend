package com.petcare.repository;

import com.petcare.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {

    List<Reminder> findAllByOrderByDueDateAsc();

    List<Reminder> findByPetIdOrderByDueDateAsc(Long petId);
}
