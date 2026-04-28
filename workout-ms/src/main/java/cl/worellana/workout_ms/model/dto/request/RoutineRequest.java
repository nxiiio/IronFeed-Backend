package cl.worellana.workout_ms.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoutineRequest {

    @NotNull
    private UUID userId;

    @NotBlank
    @Size(max = 120)
    private String name;

    @Size(max = 1000)
    private String description;
}
