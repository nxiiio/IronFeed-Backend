package cl.worellana.posts_ms.service.impl;

import cl.worellana.posts_ms.exception.CommentNotFoundException;
import cl.worellana.posts_ms.exception.PostNotFoundException;
import cl.worellana.posts_ms.model.Comment;
import cl.worellana.posts_ms.model.Post;
import cl.worellana.posts_ms.model.dto.request.CommentRequest;
import cl.worellana.posts_ms.model.dto.response.CommentResponse;
import cl.worellana.posts_ms.repository.CommentRepository;
import cl.worellana.posts_ms.repository.PostRepository;
import cl.worellana.posts_ms.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository,
                              PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    @Transactional
    public CommentResponse create(UUID postId, CommentRequest request) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);

        Comment comment = Comment.builder()
                .post(post)
                .userId(request.getUserId())
                .content(request.getContent())
                .createdAt(LocalDateTime.now())
                .build();

        return CommentResponse.from(commentRepository.save(comment));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CommentResponse> findAllByPostId(UUID postId) {
        if (!postRepository.existsById(postId)) {
            throw new PostNotFoundException();
        }

        return commentRepository.findAllByPostId(postId).stream()
                .map(CommentResponse::from)
                .toList();
    }

    @Override
    @Transactional
    public void delete(UUID postId, UUID commentId) {
        if (!postRepository.existsById(postId)) {
            throw new PostNotFoundException();
        }

        long deletedRows = commentRepository.deleteByIdAndPostId(commentId, postId);

        if (deletedRows == 0) {
            throw new CommentNotFoundException();
        }
    }
}
