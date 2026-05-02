package cl.worellana.workout_ms.model.dto.response;

import cl.worellana.workout_ms.model.PersonalRecord;
import cl.worellana.workout_ms.model.dto.response.preview.ExercisePreviewResponse;
import cl.worellana.workout_ms.model.dto.response.preview.WorkoutSessionPreviewResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalRecordResponse {

    private UUID id;
    private UUID userId;
    private ExercisePreviewResponse exercise;
    private WorkoutSessionPreviewResponse session;
    private BigDecimal weightKg;
    private Integer reps;
    private LocalDateTime achievedAt;

    public static PersonalRecordResponse from(PersonalRecord record) {
        return PersonalRecordResponse.builder()
                .id(record.getId())
                .userId(record.getUserId())
                .exercise(ExercisePreviewResponse.from(record.getExercise()))
                .session(WorkoutSessionPreviewResponse.from(record.getSession()))
                .weightKg(record.getWeightKg())
                .reps(record.getReps())
                .achievedAt(record.getAchievedAt())
                .build();
    }
}
