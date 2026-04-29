# AGENTS.md

## Scope

These instructions apply to the entire repository.

## Project Overview

IronFeed is a **backend-only** fitness social network built as **8 independent microservices** with **Event-Driven Architecture (EDA)**. There is no frontend. The only actor type is the user.

At the moment, only `users-ms` is implemented. The remaining planned services are:

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

## Working Directory and Commands

For application commands, work from `users-ms/` unless explicitly stated otherwise.

```bash
./mvnw spring-boot:run          # start the service
./mvnw test                     # run all tests
./mvnw test -Dtest=ClassName    # run a single test class
./mvnw package                  # build jar
```

To start the database, run from the project root:

```bash
docker compose up -d
```

## Architecture Rules

- Treat the system as **microservices first**: each service owns its own domain and boundaries.
- Each microservice has its own PostgreSQL database.
- Never design shared databases or cross-service joins.
- Cross-service consistency must be handled with Kafka events, not database-level foreign keys.
- Feed distribution is push-based through Kafka, not polling-based.
- Personal records are auto-detected by `workouts-ms`; users do not report them manually.
- Challenge progress is auto-updated from workout sessions; users do not report it manually.
- JWT is issued by `users-ms` and consumed by the other services, but that stack is still deferred for now.

## Current users-ms Structure

Current base package:

```text
cl.worellana.users_ms/
├── controller/   AppUserController — REST endpoints
├── service/      AppUserService    — business logic
├── repository/   AppUserRepository — JpaRepository<AppUser, UUID>
└── model/        AppUser           — JPA entity (table: "users")
```

Configuration file:

- `users-ms/src/main/resources/application.yaml` → connects to `localhost:5432/users_db`

## Conventions

- Use Lombok on entities as established in the codebase.
- Prefer Spring Boot test slices:
  - `@WebMvcTest` for controllers
  - `@DataJpaTest` for repositories
  - `@SpringBootTest` for integration tests
- Check `.docs/functional-requirements.md` for business requirements (RF-01 to RF-28) before implementing related features.
- Check `.docs/db-architecture.md` before making persistence decisions.
- `AppUser` currently uses a UUID primary key with `GenerationType.UUID`.
- IMPORTANT: `.docs/db-architecture.md` should document the current `users-ms` entity names unless a deliberate code refactor is made first.

## Do Not

- Do not implement Kafka yet.
- Do not implement Spring Security/JWT yet.
- Do not implement Spring Cloud Gateway yet.
- Do not implement Testcontainers yet.
- Do not assume planned architecture pieces are already active in the current codebase.

## Agent Behavior for This Repo

- Verify the existing code before claiming something is implemented.
- Keep recommendations aligned with the current phase of the project, not the full future architecture.
- When adding or changing code, respect current package organization unless the user explicitly requests a refactor.
- Treat planned services and deferred infrastructure as roadmap context, not as permission to implement them.
