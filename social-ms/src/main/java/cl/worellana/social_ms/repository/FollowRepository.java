package cl.worellana.social_ms.repository;

import cl.worellana.social_ms.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FollowRepository extends JpaRepository<Follow, UUID> {

    List<Follow> findAllByFollowerUserId(UUID followerUserId);

    List<Follow> findAllByFollowingUserId(UUID followingUserId);

    boolean existsByFollowerUserIdAndFollowingUserId(UUID followerUserId, UUID followingUserId);

    long deleteByFollowerUserIdAndFollowingUserId(UUID followerUserId, UUID followingUserId);
}
