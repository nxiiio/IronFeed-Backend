package cl.worellana.users_ms.service;

import cl.worellana.users_ms.model.dto.AppUserRequest;
import cl.worellana.users_ms.model.dto.AppUserResponse;

import java.util.List;
import java.util.UUID;

public interface AppUserService {
    AppUserResponse register(AppUserRequest request);
    AppUserResponse findById(UUID id);
    AppUserResponse findByUsername(String username);
    List<AppUserResponse> findAll();
    AppUserResponse updateProfile(UUID id, AppUserRequest request);
    void deleteById(UUID id);
}
