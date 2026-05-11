package cl.worellana.posts_ms.repository;

import cl.worellana.posts_ms.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

    List<Comment> findAllByPostId(UUID postId);

    long countByPostId(UUID postId);

    long deleteByIdAndPostId(UUID id, UUID postId);

    long deleteByPostId(UUID postId);
}
