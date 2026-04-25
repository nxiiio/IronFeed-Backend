package cl.worellana.users_ms.controller;

import cl.worellana.users_ms.model.dto.AppUserProfileRequest;
import cl.worellana.users_ms.model.dto.AppUserRequest;
import cl.worellana.users_ms.model.dto.AppUserResponse;
import cl.worellana.users_ms.service.AppUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping
    public ResponseEntity<AppUserResponse> register(@Valid @RequestBody AppUserRequest request) {
        AppUserResponse created = appUserService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<AppUserResponse>> findAll(
            @RequestParam(required = false) String username) {
        if (username != null) {
            return ResponseEntity.ok(List.of(appUserService.findByUsername(username)));
        }
        return ResponseEntity.ok(appUserService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUserResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(appUserService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AppUserResponse> updateProfile(@PathVariable UUID id,
                                                         @Valid @RequestBody AppUserProfileRequest request) {
        return ResponseEntity.ok(appUserService.updateProfile(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        appUserService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
