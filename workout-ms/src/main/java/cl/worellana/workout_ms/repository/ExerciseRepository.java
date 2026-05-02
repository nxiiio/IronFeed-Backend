package cl.worellana.workout_ms.repository;

import cl.worellana.workout_ms.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {

    Optional<Exercise> findBySlug(String slug);
}
