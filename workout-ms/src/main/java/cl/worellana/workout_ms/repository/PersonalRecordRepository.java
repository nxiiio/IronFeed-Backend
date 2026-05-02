package cl.worellana.workout_ms.repository;

import cl.worellana.workout_ms.model.PersonalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PersonalRecordRepository extends JpaRepository<PersonalRecord, UUID> {

    List<PersonalRecord> findAllByUserId(UUID userId);
}
