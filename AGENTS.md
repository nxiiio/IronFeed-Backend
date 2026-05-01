# AGENTS.md

## Scope

These instructions apply to the entire repository.

## Project Overview

IronFeed is a **backend-only** fitness social network built as **independent microservices** with **Event-Driven Architecture (EDA)**. There is no frontend. The only actor type is the user.

Microservices are developed incrementally. Always verify the existing service directories before claiming what is implemented. Current and planned services include:

| Service | Responsibility |
|---|---|
| users-ms | Registration, auth (JWT), user profile |
| workout-ms | Routines, completed sessions, personal records |
| posts-ms | Posts, reactions, comments |
| feed-ms | Personalized feed (no own DB — consumes Kafka events) |
| social-ms | Follow/unfollow, user search |
| challenges-ms | Challenge creation, enrollment, progress tracking |
| rankings-ms | Weekly volume, active streak, personal record rankings |
| notifications-ms | Real-time notifications |

## Working Directory and Commands

For application commands, work from the specific microservice directory being changed, for example `users-ms/` or `workout-ms/`.

```bash
./mvnw spring-boot:run          # start the selected service only when explicitly requested
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
- Personal records are auto-detected by the workout service; users do not report them manually.
- Challenge progress is auto-updated from workout sessions; users do not report it manually.
- JWT is issued by `users-ms` and consumed by the other services, but that stack is still deferred for now.

## Microservice Structure Pattern

Apply the same structure pattern to every microservice unless the existing code in that microservice already establishes a deliberate variation:

```text
{microservice}/src/main/java/cl/worellana/{microservice_package}/
├── model/        JPA entities and domain models
├── exception/    Custom exceptions for the microservice
├── repository/   Spring Data repositories
├── service/      Business logic and transactions
└── controller/   REST endpoints
```

Configuration file:

- `{microservice}/src/main/resources/application.yaml` → connects to `localhost:5432/{microservice}_db`

## Conventions

- Use Lombok on entities as established in the codebase.
- Develop each microservice by layers in this order: **entity/model first**, then **service**, then **controller**.
- Keep controllers thin; business rules belong in services, and persistence details belong in repositories/entities.
- Check `.docs/functional-requirements.md` for business requirements (RF-01 to RF-28) before implementing related features.
- Check `.docs/db-architecture.md` before making persistence decisions.
- Prefer UUID primary keys for microservice-owned entities unless an existing entity or documentation deliberately says otherwise.
- IMPORTANT: `.docs/db-architecture.md` should document the current entity names unless a deliberate code refactor is made first.

## Do Not

- Do not implement Kafka yet.
- Do not implement Spring Security/JWT yet.
- Do not implement Spring Cloud Gateway yet.
- Do not implement Testcontainers yet.
- Do not create, implement, or run tests unless the user explicitly changes this rule.
- Do not run builds or package commands after changes.
- Do not assume planned architecture pieces are already active in the current codebase.

## Agent Behavior for This Repo

- Verify the existing code before claiming something is implemented.
- Keep recommendations aligned with the current phase of the project, not the full future architecture.
- When adding or changing code, respect current package organization unless the user explicitly requests a refactor.
- Treat planned services and deferred infrastructure as roadmap context, not as permission to implement them.
