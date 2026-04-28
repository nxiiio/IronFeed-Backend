package cl.worellana.workout_ms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "routine")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "routine_id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "user_id", nullable = false, updatable = false)
    private UUID userId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 4000)
    private String description;
}
