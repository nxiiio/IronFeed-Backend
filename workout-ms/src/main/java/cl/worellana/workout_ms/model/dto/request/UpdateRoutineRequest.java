package cl.worellana.workout_ms.model.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoutineRequest {

    @Size(max = 120)
    private String name;

    @Size(max = 1000)
    private String description;
}
