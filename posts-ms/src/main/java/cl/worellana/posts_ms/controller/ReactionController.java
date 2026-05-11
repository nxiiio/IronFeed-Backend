package cl.worellana.posts_ms.controller;

import cl.worellana.posts_ms.model.dto.request.ReactionRequest;
import cl.worellana.posts_ms.model.dto.response.ReactionResponse;
import cl.worellana.posts_ms.service.ReactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/posts/{postId}/reactions")
public class ReactionController {

    private final ReactionService reactionService;

    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    @PostMapping
    public ResponseEntity<ReactionResponse> react(@PathVariable UUID postId,
                                                  @Valid @RequestBody ReactionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reactionService.react(postId, request));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteReaction(@PathVariable UUID postId,
                                               @PathVariable UUID userId) {
        reactionService.deleteReaction(postId, userId);
        return ResponseEntity.noContent().build();
    }
}
