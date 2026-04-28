package cl.worellana.workout_ms.service.impl;

import cl.worellana.workout_ms.model.Routine;
import cl.worellana.workout_ms.model.dto.request.RoutineRequest;
import cl.worellana.workout_ms.model.dto.response.RoutineResponse;
import cl.worellana.workout_ms.repository.RoutineRepository;
import cl.worellana.workout_ms.service.RoutineService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class RoutineServiceImpl implements RoutineService {

    private final RoutineRepository routineRepository;

    public RoutineServiceImpl(RoutineRepository routineRepository) {
        this.routineRepository = routineRepository;
    }

    @Override
    @Transactional
    public RoutineResponse create(RoutineRequest request) {
        Routine routine = Routine.builder()
                .userId(request.getUserId())
                .name(request.getName())
                .description(request.getDescription())
                .build();
        return RoutineResponse.from(routineRepository.save(routine));
    }

    @Override
    @Transactional(readOnly = true)
    public RoutineResponse findById(UUID id) {
        return routineRepository.findById(id)
                .map(RoutineResponse::from)
                .orElseThrow(() -> new EntityNotFoundException("Rutina no encontrada."));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoutineResponse> findAllByUserId(UUID userId) {
        return routineRepository.findAllByUserId(userId).stream()
                .map(RoutineResponse::from)
                .toList();
    }

    @Override
    @Transactional
    public RoutineResponse update(UUID id, RoutineRequest request) {
        Routine routine = routineRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rutina no encontrada."));
        if (request.getName() != null) {
            routine.setName(request.getName());
        }
        if (request.getDescription() != null) {
            routine.setDescription(request.getDescription());
        }
        return RoutineResponse.from(routineRepository.save(routine));
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        if (!routineRepository.existsById(id)) {
            throw new EntityNotFoundException("Rutina no encontrada.");
        }
        routineRepository.deleteById(id);
    }
}
