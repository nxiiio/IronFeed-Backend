package cl.worellana.social_ms.model.dto.response;

import cl.worellana.social_ms.model.Follow;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FollowResponse {

    private UUID id;
    private UUID followerUserId;
    private UUID followingUserId;

    public static FollowResponse from(Follow follow) {
        return FollowResponse.builder()
                .id(follow.getId())
                .followerUserId(follow.getFollowerUserId())
                .followingUserId(follow.getFollowingUserId())
                .build();
    }
}
