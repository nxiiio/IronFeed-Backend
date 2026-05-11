package cl.worellana.posts_ms.controller;

import cl.worellana.posts_ms.model.dto.request.CommentRequest;
import cl.worellana.posts_ms.model.dto.response.CommentResponse;
import cl.worellana.posts_ms.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentResponse> create(@PathVariable UUID postId,
                                                  @Valid @RequestBody CommentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.create(postId, request));
    }

    @GetMapping
    public ResponseEntity<List<CommentResponse>> findAllByPostId(@PathVariable UUID postId) {
        return ResponseEntity.ok(commentService.findAllByPostId(postId));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> delete(@PathVariable UUID postId,
                                       @PathVariable UUID commentId) {
        commentService.delete(postId, commentId);
        return ResponseEntity.noContent().build();
    }
}
