package cl.worellana.posts_ms.model.dto.response;

import cl.worellana.posts_ms.model.Reaction;
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
public class ReactionResponse {

    private UUID id;
    private UUID postId;
    private UUID reactorId;
    private LocalDateTime createdAt;

    public static ReactionResponse from(Reaction reaction) {
        return ReactionResponse.builder()
                .id(reaction.getId())
                .postId(reaction.getPost().getId())
                .reactorId(reaction.getUserId())
                .createdAt(reaction.getCreatedAt())
                .build();
    }
}
