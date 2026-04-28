package cl.worellana.workout_ms.service;

import cl.worellana.workout_ms.model.dto.response.PersonalRecordResponse;

import java.util.List;
import java.util.UUID;

public interface PersonalRecordService {

    PersonalRecordResponse findById(UUID id);

    List<PersonalRecordResponse> findAllByUserId(UUID userId);

    List<PersonalRecordResponse> findAllByUserIdAndExerciseId(UUID userId, UUID exerciseId);
}
