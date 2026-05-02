package cl.worellana.workout_ms.model.dto.response.preview;

import cl.worellana.workout_ms.model.Routine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoutinePreviewResponse {

    private UUID id;
    private String name;

    public static RoutinePreviewResponse from(Routine routine) {
        return RoutinePreviewResponse.builder()
                .id(routine.getId())
                .name(routine.getName())
                .build();
    }
}
