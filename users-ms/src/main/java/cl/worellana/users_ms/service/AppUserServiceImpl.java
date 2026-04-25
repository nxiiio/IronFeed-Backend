package cl.worellana.users_ms.service;

import cl.worellana.users_ms.exception.EmailAlreadyExistsException;
import cl.worellana.users_ms.exception.UsernameAlreadyExistsException;
import cl.worellana.users_ms.model.dto.AppUserProfileRequest;
import cl.worellana.users_ms.model.dto.AppUserRequest;
import cl.worellana.users_ms.model.dto.AppUserResponse;
import cl.worellana.users_ms.model.AppUser;
import cl.worellana.users_ms.repository.AppUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    @Transactional
    public AppUserResponse register(AppUserRequest request) {
        if (appUserRepository.existsByUsername(request.getUsername())) {
            throw new UsernameAlreadyExistsException();
        }
        if (appUserRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException();
        }
        AppUser saved = appUserRepository.save(AppUser.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .passwordHash(request.getPassword()) // hashear contraseña
                .name(request.getName())
                .lastname(request.getLastname())
                .bio(request.getBio())
                .build());
        return AppUserResponse.from(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public AppUserResponse findById(UUID id) {
        return appUserRepository.findById(id)
                .map(AppUserResponse::from)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public AppUserResponse findByUsername(String username) {
        return appUserRepository.findByUsername(username)
                .map(AppUserResponse::from)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + username));
    }

    @Override
    @Transactional(readOnly = true)
    public List<AppUserResponse> findAll() {
        return appUserRepository.findAll().stream()
                .map(AppUserResponse::from)
                .toList();
    }

    @Override
    @Transactional
    public AppUserResponse updateProfile(UUID id, AppUserProfileRequest request) {
        AppUser user = appUserRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + id));
        if (request.getName() != null) {
            user.setName(request.getName());
        }
        if (request.getLastname() != null) {
            user.setLastname(request.getLastname());
        }
        if (request.getBio() != null) {
            user.setBio(request.getBio());
        }
        return AppUserResponse.from(user);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        if (!appUserRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found: " + id);
        }
        appUserRepository.deleteById(id);
    }
}
