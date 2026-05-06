package cl.worellana.social_ms.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FollowRequest {

    @NotNull
    private UUID followerUserId;

    @NotNull
    private UUID followingUserId;
}
