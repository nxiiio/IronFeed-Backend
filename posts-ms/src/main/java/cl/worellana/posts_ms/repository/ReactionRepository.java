package cl.worellana.posts_ms.repository;

import cl.worellana.posts_ms.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReactionRepository extends JpaRepository<Reaction, UUID> {

    boolean existsByPostIdAndUserId(UUID postId, UUID userId);

    long deleteByPostIdAndUserId(UUID postId, UUID userId);

    long deleteByPostId(UUID postId);

    long countByPostId(UUID postId);
}
