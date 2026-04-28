package cl.worellana.workout_ms.repository;

import cl.worellana.workout_ms.model.WorkoutSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession, UUID> {

    List<WorkoutSession> findAllByUserId(UUID userId);
}
