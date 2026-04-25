package cl.worellana.users_ms.model.dto;

import cl.worellana.users_ms.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUserResponse {

    private UUID id;
    private String username;
    private String email;
    private String name;
    private String lastname;
    private String bio;

    public static AppUserResponse from(AppUser user) {
        return AppUserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .name(user.getName())
                .lastname(user.getLastname())
                .bio(user.getBio())
                .build();
    }
}
