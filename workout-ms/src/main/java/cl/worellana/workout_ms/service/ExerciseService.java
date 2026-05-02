package cl.worellana.workout_ms.service;

import cl.worellana.workout_ms.model.dto.response.ExerciseResponse;

import java.util.List;
import java.util.UUID;

public interface ExerciseService {

    ExerciseResponse findById(UUID id);

    ExerciseResponse findBySlug(String slug);

    List<ExerciseResponse> findAll();
}
