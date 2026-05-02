package cl.worellana.workout_ms.service.impl;

import cl.worellana.workout_ms.model.Routine;
import cl.worellana.workout_ms.model.WorkoutSession;
import cl.worellana.workout_ms.model.dto.request.WorkoutSessionRequest;
import cl.worellana.workout_ms.model.dto.response.WorkoutSessionResponse;
import cl.worellana.workout_ms.repository.RoutineRepository;
import cl.worellana.workout_ms.repository.WorkoutSessionRepository;
import cl.worellana.workout_ms.service.WorkoutSessionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class WorkoutSessionServiceImpl implements WorkoutSessionService {

    private final WorkoutSessionRepository sessionRepository;
    private final RoutineRepository routineRepository;

    public WorkoutSessionServiceImpl(WorkoutSessionRepository sessionRepository,
                                     RoutineRepository routineRepository) {
        this.sessionRepository = sessionRepository;
        this.routineRepository = routineRepository;
    }

    @Override
    @Transactional
    public WorkoutSessionResponse create(WorkoutSessionRequest request) {
        Routine routine = null;
        if (request.getRoutineId() != null) {
            routine = routineRepository.findById(request.getRoutineId())
                    .orElseThrow(() -> new EntityNotFoundException("Rutina no encontrada."));
        }
        WorkoutSession session = WorkoutSession.builder()
                .userId(request.getUserId())
                .routine(routine)
                .startedAt(request.getStartedAt())
                .finishedAt(request.getFinishedAt())
                .notes(request.getNotes())
                .build();
        return WorkoutSessionResponse.from(sessionRepository.save(session));
    }

    @Override
    @Transactional(readOnly = true)
    public WorkoutSessionResponse findById(UUID id) {
        return sessionRepository.findById(id)
                .map(WorkoutSessionResponse::from)
                .orElseThrow(() -> new EntityNotFoundException("Sesión no encontrada."));
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkoutSessionResponse> findAll() {
        return sessionRepository.findAll().stream()
                .map(WorkoutSessionResponse::from)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkoutSessionResponse> findAllByUserId(UUID userId) {
        return sessionRepository.findAllByUserId(userId).stream()
                .map(WorkoutSessionResponse::from)
                .toList();
    }
}
