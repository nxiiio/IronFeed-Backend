package cl.worellana.workout_ms.model.dto.response.preview;

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
public class WorkoutSessionPreviewResponse {

    private UUID id;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;
    private String notes;

    public static WorkoutSessionPreviewResponse from(WorkoutSession session) {
        return WorkoutSessionPreviewResponse.builder()
                .id(session.getId())
                .startedAt(session.getStartedAt())
                .finishedAt(session.getFinishedAt())
                .notes(session.getNotes())
                .build();
    }
}
