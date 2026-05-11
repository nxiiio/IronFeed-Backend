package cl.worellana.posts_ms.service;

import cl.worellana.posts_ms.model.dto.request.ReactionRequest;
import cl.worellana.posts_ms.model.dto.response.ReactionResponse;

import java.util.UUID;

public interface ReactionService {

    ReactionResponse react(UUID postId, ReactionRequest request);

    void deleteReaction(UUID postId, UUID userId);
}
