package cl.worellana.workout_ms.controller;

import cl.worellana.workout_ms.model.dto.request.RoutineRequest;
import cl.worellana.workout_ms.model.dto.request.UpdateRoutineRequest;
import cl.worellana.workout_ms.model.dto.response.RoutineResponse;
import cl.worellana.workout_ms.service.RoutineService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/routines")
public class RoutineController {

    private final RoutineService routineService;

    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;
    }

    @PostMapping
    public ResponseEntity<RoutineResponse> create(@Valid @RequestBody RoutineRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(routineService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<RoutineResponse>> findAllByUserId(@RequestParam UUID userId) {
        return ResponseEntity.ok(routineService.findAllByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoutineResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(routineService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RoutineResponse> update(@PathVariable UUID id,
                                                  @Valid @RequestBody UpdateRoutineRequest request) {
        return ResponseEntity.ok(routineService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        routineService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}