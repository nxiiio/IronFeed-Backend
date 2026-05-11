package cl.worellana.posts_ms.model.dto.request;

import cl.worellana.posts_ms.model.PostType;
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
public class PostRequest {

    @NotNull
    private UUID userId;

    @NotNull
    private PostType type;

    private UUID workoutSessionId;

    private UUID personalRecordId;

    @Size(max = 4000)
    private String caption;

    @Size(max = 255)
    private String imageUrl;
}
