package cl.worellana.workout_ms.service;

import cl.worellana.workout_ms.model.dto.request.WorkoutSessionRequest;
import cl.worellana.workout_ms.model.dto.response.WorkoutSessionResponse;

import java.util.List;
import java.util.UUID;

public interface WorkoutSessionService {

    WorkoutSessionResponse create(WorkoutSessionRequest request);

    WorkoutSessionResponse findById(UUID id);

    List<WorkoutSessionResponse> findAll();

    List<WorkoutSessionResponse> findAllByUserId(UUID userId);
}
