package cl.worellana.workout_ms.model.dto.response;

import cl.worellana.workout_ms.model.PersonalRecord;
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
    private UUID exerciseId;
    private UUID sessionId;
    private BigDecimal weightKg;
    private Integer reps;
    private LocalDateTime achievedAt;

    public static PersonalRecordResponse from(PersonalRecord record) {
        return PersonalRecordResponse.builder()
                .id(record.getId())
                .userId(record.getUserId())
                .exerciseId(record.getExercise().getId())
                .sessionId(record.getSession().getId())
                .weightKg(record.getWeightKg())
                .reps(record.getReps())
                .achievedAt(record.getAchievedAt())
                .build();
    }
}
