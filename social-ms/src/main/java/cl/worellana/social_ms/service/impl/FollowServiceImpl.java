package cl.worellana.social_ms.service.impl;

import cl.worellana.social_ms.exception.FollowAlreadyExistsException;
import cl.worellana.social_ms.exception.FollowNotFoundException;
import cl.worellana.social_ms.exception.SelfFollowNotAllowedException;
import cl.worellana.social_ms.model.Follow;
import cl.worellana.social_ms.model.dto.request.FollowRequest;
import cl.worellana.social_ms.model.dto.response.FollowResponse;
import cl.worellana.social_ms.repository.FollowRepository;
import cl.worellana.social_ms.service.FollowService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;

    public FollowServiceImpl(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    @Override
    @Transactional
    public FollowResponse follow(FollowRequest request) {
        validateDifferentUsers(request);

        if (followRepository.existsByFollowerUserIdAndFollowingUserId(
                request.getFollowerUserId(),
                request.getFollowingUserId())) {
            throw new FollowAlreadyExistsException();
        }

        Follow follow = Follow.builder()
                .followerUserId(request.getFollowerUserId())
                .followingUserId(request.getFollowingUserId())
                .build();

        return FollowResponse.from(followRepository.save(follow));
    }

    @Override
    @Transactional
    public void unfollow(FollowRequest request) {
        validateDifferentUsers(request);

        long deletedRows = followRepository.deleteByFollowerUserIdAndFollowingUserId(
                request.getFollowerUserId(),
                request.getFollowingUserId());

        if (deletedRows == 0) {
            throw new FollowNotFoundException();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<FollowResponse> findAllByFollowerUserId(UUID followerUserId) {
        return followRepository.findAllByFollowerUserId(followerUserId).stream()
                .map(FollowResponse::from)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<FollowResponse> findAllByFollowingUserId(UUID followingUserId) {
        return followRepository.findAllByFollowingUserId(followingUserId).stream()
                .map(FollowResponse::from)
                .toList();
    }

    private void validateDifferentUsers(FollowRequest request) {
        if (request.getFollowerUserId().equals(request.getFollowingUserId())) {
            throw new SelfFollowNotAllowedException();
        }
    }
}
