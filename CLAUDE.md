# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

All commands run from `users-ms/`:

```bash
./mvnw spring-boot:run          # start the service
./mvnw test                     # run all tests
./mvnw test -Dtest=ClassName    # run a single test class
./mvnw package                  # build jar
```

Start the database before running the service:
```bash
docker compose up -d            # from project root
```

## Architecture

IronFeed is a **backend-only** fitness social network built as **8 independent microservices** with Event-Driven Architecture (EDA). No frontend. One actor type: the user.

Only `users-ms` is implemented. The remaining 7 services are planned:

| Service | Responsibility |
|---|---|
| users-ms | Registration, auth (JWT), user profile |
| workouts-ms | Routines, completed sessions, personal records |
| posts-ms | Posts, reactions, comments |
| feed-ms | Personalized feed (no own DB — consumes Kafka events) |
| social-ms | Follow/unfollow, user search |
| challenges-ms | Challenge creation, enrollment, progress tracking |
| rankings-ms | Weekly volume, active streak, personal record rankings |
| notifications-ms | Real-time notifications |

**Key design rules:**
- Each microservice has its own PostgreSQL database — no shared DBs, no cross-service joins
- Cross-service data consistency is achieved via Kafka events, not DB-level foreign keys
- Feed distribution is push-based (Kafka), not polling
- Personal records are auto-detected by workouts-ms — users don't report them
- Challenge progress is auto-updated from workout sessions — no manual reporting
- JWT is issued by users-ms and consumed by all other services

## users-ms Structure

```
cl.worellana.users_ms/
├── controller/   AppUserController — REST endpoints
├── service/      AppUserService    — business logic
├── repository/   AppUserRepository — JpaRepository<AppUser, Long>
└── model/        AppUser           — JPA entity (table: "users")
```

Config: `src/main/resources/application.yaml` — connects to `localhost:5432/users_db`.

## Conventions

- Lombok is used on all entities (`@Data`, `@NoArgsConstructor`, `@Builder`)
- Tests use Spring Boot test slices: `@WebMvcTest` for controllers, `@DataJpaTest` for repositories, `@SpringBootTest` for integration
- DB schema (`.docs/db-architecture.md`) specifies UUID PKs — `AppUser` currently uses `Long` with `IDENTITY` strategy; align before adding new services
- Functional requirements are in `.docs/functional-requirements.md` (RF-01 to RF-28)

## Do Not

- Do not implement Kafka, Spring Security/JWT, Spring Cloud Gateway, or Testcontainers — these are planned but intentionally deferred
