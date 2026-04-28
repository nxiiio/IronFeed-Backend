package cl.worellana.workout_ms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "personal_record")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "record_id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "user_id", nullable = false, updatable = false)
    private UUID userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    private WorkoutSession session;

    @Column(name = "weight_kg", precision = 5, scale = 2)
    private BigDecimal weightKg;

    @Column(name = "reps")
    private Integer reps;

    @Column(name = "achieved_at")
    private LocalDateTime achievedAt;
}
