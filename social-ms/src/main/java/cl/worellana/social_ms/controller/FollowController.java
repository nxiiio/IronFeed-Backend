package cl.worellana.social_ms.controller;

import cl.worellana.social_ms.model.dto.request.FollowRequest;
import cl.worellana.social_ms.model.dto.response.FollowResponse;
import cl.worellana.social_ms.service.FollowService;
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
@RequestMapping("/api/follows")
public class FollowController {

    private final FollowService followService;

    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping
    public ResponseEntity<FollowResponse> follow(@Valid @RequestBody FollowRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(followService.follow(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> unfollow(@Valid @RequestBody FollowRequest request) {
        followService.unfollow(request);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/following/{userId}")
    public ResponseEntity<List<FollowResponse>> findAllByFollowerUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(followService.findAllByFollowerUserId(userId));
    }

    @GetMapping("/followers/{userId}")
    public ResponseEntity<List<FollowResponse>> findAllByFollowingUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(followService.findAllByFollowingUserId(userId));
    }
}
