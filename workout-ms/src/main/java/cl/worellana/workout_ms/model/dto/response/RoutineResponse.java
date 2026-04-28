package cl.worellana.workout_ms.model.dto.response;

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
public class RoutineResponse {

    private UUID id;
    private UUID userId;
    private String name;
    private String description;

    public static RoutineResponse from(Routine routine) {
        return RoutineResponse.builder()
                .id(routine.getId())
                .userId(routine.getUserId())
                .name(routine.getName())
                .description(routine.getDescription())
                .build();
    }
}
