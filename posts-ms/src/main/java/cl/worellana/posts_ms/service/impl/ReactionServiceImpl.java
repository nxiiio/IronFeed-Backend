package cl.worellana.posts_ms.service.impl;

import cl.worellana.posts_ms.exception.PostNotFoundException;
import cl.worellana.posts_ms.exception.ReactionAlreadyExistsException;
import cl.worellana.posts_ms.exception.ReactionNotFoundException;
import cl.worellana.posts_ms.model.Post;
import cl.worellana.posts_ms.model.Reaction;
import cl.worellana.posts_ms.model.dto.request.ReactionRequest;
import cl.worellana.posts_ms.model.dto.response.ReactionResponse;
import cl.worellana.posts_ms.repository.PostRepository;
import cl.worellana.posts_ms.repository.ReactionRepository;
import cl.worellana.posts_ms.service.ReactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ReactionServiceImpl implements ReactionService {

    private final ReactionRepository reactionRepository;
    private final PostRepository postRepository;

    public ReactionServiceImpl(ReactionRepository reactionRepository,
                               PostRepository postRepository) {
        this.reactionRepository = reactionRepository;
        this.postRepository = postRepository;
    }

    @Override
    @Transactional
    public ReactionResponse react(UUID postId, ReactionRequest request) {
        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);

        if (reactionRepository.existsByPostIdAndUserId(postId, request.getUserId())) {
            throw new ReactionAlreadyExistsException();
        }

        Reaction reaction = Reaction.builder()
                .post(post)
                .userId(request.getUserId())
                .createdAt(LocalDateTime.now())
                .build();

        return ReactionResponse.from(reactionRepository.save(reaction));
    }

    @Override
    @Transactional
    public void deleteReaction(UUID postId, UUID userId) {
        long deletedRows = reactionRepository.deleteByPostIdAndUserId(postId, userId);

        if (deletedRows == 0) {
            throw new ReactionNotFoundException();
        }
    }
}
