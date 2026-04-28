package cl.worellana.workout_ms.repository;

import cl.worellana.workout_ms.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RoutineRepository extends JpaRepository<Routine, UUID> {

    List<Routine> findAllByUserId(UUID userId);
}
