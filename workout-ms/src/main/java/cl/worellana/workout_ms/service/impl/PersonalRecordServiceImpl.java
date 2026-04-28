package cl.worellana.workout_ms.service.impl;

import cl.worellana.workout_ms.model.dto.response.PersonalRecordResponse;
import cl.worellana.workout_ms.repository.PersonalRecordRepository;
import cl.worellana.workout_ms.service.PersonalRecordService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PersonalRecordServiceImpl implements PersonalRecordService {

    private final PersonalRecordRepository personalRecordRepository;

    public PersonalRecordServiceImpl(PersonalRecordRepository personalRecordRepository) {
        this.personalRecordRepository = personalRecordRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public PersonalRecordResponse findById(UUID id) {
        return personalRecordRepository.findById(id)
                .map(PersonalRecordResponse::from)
                .orElseThrow(() -> new EntityNotFoundException("Récord personal no encontrado."));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalRecordResponse> findAllByUserId(UUID userId) {
        return personalRecordRepository.findAllByUserId(userId).stream()
                .map(PersonalRecordResponse::from)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalRecordResponse> findAllByUserIdAndExerciseId(UUID userId, UUID exerciseId) {
        return personalRecordRepository.findAllByUserIdAndExerciseId(userId, exerciseId).stream()
                .map(PersonalRecordResponse::from)
                .toList();
    }
}
