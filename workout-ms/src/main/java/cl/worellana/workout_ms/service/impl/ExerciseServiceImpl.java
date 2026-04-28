package cl.worellana.workout_ms.service.impl;

import cl.worellana.workout_ms.model.dto.response.ExerciseResponse;
import cl.worellana.workout_ms.repository.ExerciseRepository;
import cl.worellana.workout_ms.service.ExerciseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public ExerciseResponse findById(UUID id) {
        return exerciseRepository.findById(id)
                .map(ExerciseResponse::from)
                .orElseThrow(() -> new EntityNotFoundException("Ejercicio no encontrado."));
    }

    @Override
    @Transactional(readOnly = true)
    public ExerciseResponse findByName(String name) {
        return exerciseRepository.findByName(name)
                .map(ExerciseResponse::from)
                .orElseThrow(() -> new EntityNotFoundException("Ejercicio no encontrado."));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExerciseResponse> findAll() {
        return exerciseRepository.findAll().stream()
                .map(ExerciseResponse::from)
                .toList();
    }
}
