package cl.worellana.workout_ms.model.dto.response;

import cl.worellana.workout_ms.model.Exercise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseResponse {

    private UUID id;
    private String name;
    private String slug;
    private String muscleGroup;
    private String description;

    public static ExerciseResponse from(Exercise exercise) {
        return ExerciseResponse.builder()
                .id(exercise.getId())
                .name(exercise.getName())
                .slug(exercise.getSlug())
                .muscleGroup(exercise.getMuscleGroup())
                .description(exercise.getDescription())
                .build();
    }
}
