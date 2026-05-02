package cl.worellana.workout_ms.service;

import cl.worellana.workout_ms.model.dto.request.RoutineRequest;
import cl.worellana.workout_ms.model.dto.request.UpdateRoutineRequest;
import cl.worellana.workout_ms.model.dto.response.RoutineResponse;

import java.util.List;
import java.util.UUID;

public interface RoutineService {

    RoutineResponse create(RoutineRequest request);

    RoutineResponse findById(UUID id);

    List<RoutineResponse> findAll();

    List<RoutineResponse> findAllByUserId(UUID userId);

    RoutineResponse update(UUID id, UpdateRoutineRequest request);

    void deleteById(UUID id);
}
