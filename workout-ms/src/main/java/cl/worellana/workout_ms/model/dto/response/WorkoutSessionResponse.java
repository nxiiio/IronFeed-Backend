package cl.worellana.workout_ms.model.dto.response;

import cl.worellana.workout_ms.model.WorkoutSession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutSessionResponse {

    private UUID id;
    private UUID userId;
    private UUID routineId;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;
    private String notes;

    public static WorkoutSessionResponse from(WorkoutSession session) {
        return WorkoutSessionResponse.builder()
                .id(session.getId())
                .userId(session.getUserId())
                .routineId(session.getRoutine() != null ? session.getRoutine().getId() : null)
                .startedAt(session.getStartedAt())
                .finishedAt(session.getFinishedAt())
                .notes(session.getNotes())
                .build();
    }
}
