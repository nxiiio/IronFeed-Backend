package cl.worellana.users_ms.model.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUserProfileRequest {

    @Size(max = 100)
    private String name;

    @Size(max = 100)
    private String lastname;

    @Size(max = 4000)
    private String bio;
}
