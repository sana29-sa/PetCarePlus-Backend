
package com.petcare.repository;

import com.petcare.model.CareRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CareRecordRepository extends JpaRepository<CareRecord, Long> {
    List<CareRecord> findByPetIdOrderByRecordDateDesc(Long petId);
}
