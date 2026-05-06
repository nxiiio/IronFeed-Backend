package cl.worellana.social_ms.service;

import cl.worellana.social_ms.model.dto.request.FollowRequest;
import cl.worellana.social_ms.model.dto.response.FollowResponse;

import java.util.List;
import java.util.UUID;

public interface FollowService {

    FollowResponse follow(FollowRequest request);

    void unfollow(FollowRequest request);

    List<FollowResponse> findAllByFollowerUserId(UUID followerUserId);

    List<FollowResponse> findAllByFollowingUserId(UUID followingUserId);
}
