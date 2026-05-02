package cl.worellana.workout_ms.model.dto.response.preview;

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
public class ExercisePreviewResponse {

    private UUID id;
    private String name;
    private String slug;
    private String muscleGroup;

    public static ExercisePreviewResponse from(Exercise exercise) {
        return ExercisePreviewResponse.builder()
                .id(exercise.getId())
                .name(exercise.getName())
                .slug(exercise.getSlug())
                .muscleGroup(exercise.getMuscleGroup())
                .build();
    }
}
