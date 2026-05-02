package cl.worellana.workout_ms.controller;

import cl.worellana.workout_ms.model.dto.request.WorkoutSessionRequest;
import cl.worellana.workout_ms.model.dto.response.WorkoutSessionResponse;
import cl.worellana.workout_ms.service.WorkoutSessionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/workout-sessions")
public class WorkoutSessionController {

    private final WorkoutSessionService workoutSessionService;

    public WorkoutSessionController(WorkoutSessionService workoutSessionService) {
        this.workoutSessionService = workoutSessionService;
    }

    @PostMapping
    public ResponseEntity<WorkoutSessionResponse> create(@Valid @RequestBody WorkoutSessionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(workoutSessionService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<WorkoutSessionResponse>> findAll(@RequestParam(required = false) UUID userId) {
        if (userId == null) {
            return ResponseEntity.ok(workoutSessionService.findAll());
        }
        return ResponseEntity.ok(workoutSessionService.findAllByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutSessionResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(workoutSessionService.findById(id));
    }
}