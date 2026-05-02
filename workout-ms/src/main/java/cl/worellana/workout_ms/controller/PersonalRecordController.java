package cl.worellana.workout_ms.controller;

import cl.worellana.workout_ms.model.dto.response.PersonalRecordResponse;
import cl.worellana.workout_ms.service.PersonalRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/personal-records")
public class PersonalRecordController {

    private final PersonalRecordService personalRecordService;

    public PersonalRecordController(PersonalRecordService personalRecordService) {
        this.personalRecordService = personalRecordService;
    }

    @GetMapping
    public ResponseEntity<List<PersonalRecordResponse>> findAll(@RequestParam(required = false) UUID userId,
                                                                @RequestParam(required = false) UUID exerciseId) {
        if (userId == null) {
            return ResponseEntity.ok(personalRecordService.findAll());
        }
        if (exerciseId != null) {
            return ResponseEntity.ok(personalRecordService.findAllByUserIdAndExerciseId(userId, exerciseId));
        }
        return ResponseEntity.ok(personalRecordService.findAllByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalRecordResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(personalRecordService.findById(id));
    }
}
