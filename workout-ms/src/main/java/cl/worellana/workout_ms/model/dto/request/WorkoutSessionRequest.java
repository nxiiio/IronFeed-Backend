package cl.worellana.workout_ms.model.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
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
public class WorkoutSessionRequest {

    @NotNull
    private UUID userId;

    private UUID routineId;

    @NotNull
    @PastOrPresent
    private LocalDateTime startedAt;

    @PastOrPresent
    private LocalDateTime finishedAt;

    @Size(max = 2000)
    private String notes;
}
