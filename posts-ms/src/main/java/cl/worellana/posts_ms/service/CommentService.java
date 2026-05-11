package cl.worellana.posts_ms.service;

import cl.worellana.posts_ms.model.dto.request.CommentRequest;
import cl.worellana.posts_ms.model.dto.response.CommentResponse;

import java.util.List;
import java.util.UUID;

public interface CommentService {

    CommentResponse create(UUID postId, CommentRequest request);

    List<CommentResponse> findAllByPostId(UUID postId);

    void delete(UUID postId, UUID commentId);
}
