package cl.worellana.workout_ms.controller;

import cl.worellana.workout_ms.model.dto.response.ExerciseResponse;
import cl.worellana.workout_ms.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public ResponseEntity<List<ExerciseResponse>> findAll(
            @RequestParam(required = false) String slug) {
        if (slug != null) {
            return ResponseEntity.ok(List.of(exerciseService.findBySlug(slug)));
        }
        return ResponseEntity.ok(exerciseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(exerciseService.findById(id));
    }
}
