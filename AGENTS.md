# AGENTS.md

## Scope

These instructions apply to the entire repository.

## Project Overview

IronFeed is a **backend-only** fitness social network built as **independent microservices** with an eventual **Event-Driven Architecture (EDA)**. There is no frontend. The only actor type is the user.

Microservices are developed incrementally. Always verify the existing directories and code before claiming what is implemented.

## Current Modules

These modules currently exist in the repository:

| Module | Responsibility | Current role |
|---|---|---|
| `users-ms` | Registration, user profile, user-owned data | Microservice |
| `workout-ms` | Exercises, routines, workout sessions, personal records | Microservice |
| `social-ms` | Follow/unfollow relationships | Microservice |
| `api-gateway` | Routes requests to existing services | Gateway module |

Pending microservices:

| Service | Responsibility |
|---|---|
| `posts-ms` | Posts, reactions, comments |
| `feed-ms` | Personalized feed |
| `challenges-ms` | Challenge creation, enrollment, progress tracking |
| `rankings-ms` | Weekly volume, active streak, personal record rankings |
| `notifications-ms` | Real-time notifications |

`api-gateway` exists, but its existence does **not** authorize adding JWT, security, Kafka, discovery, or broader infrastructure unless the user explicitly asks for it.

## Working Directory and Commands

For application commands, work from the specific module being changed, for example `users-ms/`, `workout-ms/`, `social-ms/`, or `api-gateway/`.

```bash
./mvnw spring-boot:run          # start the selected module only when explicitly requested
```

To start the database, run from the project root only when explicitly requested:

```bash
docker compose up -d
```

## Architecture Rules

- Treat the system as **microservices first**: each microservice owns its own domain and boundaries.
- Each microservice owns its own PostgreSQL database.
- Never design shared databases or cross-service joins.
- Cross-service user references are logical UUID references, not physical foreign keys.
- Cross-service consistency will be handled by events later, not database-level foreign keys.
- Feed distribution is intended to be push-based through events later, not polling-based.
- Personal records are auto-detected by the workout service; users do not report them manually.
- Challenge progress is auto-updated from workout sessions; users do not report it manually.
- JWT is expected to be issued by `users-ms` and consumed by other services later, but that stack is deferred for now.

## Deferred Infrastructure

The following are roadmap items only. Do **not** implement or expand them unless the user explicitly asks:

- Kafka or any messaging/event infrastructure.
- Spring Security, JWT, auth filters, or authorization rules.
- Testcontainers or test infrastructure.
- Additional API Gateway infrastructure beyond explicitly requested route/error handling.
- Service discovery, Eureka, or Spring Cloud infrastructure beyond the current gateway setup.

## Microservice Structure Pattern

Apply this structure pattern to every microservice unless the existing code in that microservice already establishes a deliberate variation:

```text
{microservice}/src/main/java/cl/worellana/{microservice_package}/
├── model/        JPA entities and domain models
├── model/dto/    Request and response DTOs
├── exception/    Custom exceptions for the microservice
├── repository/   Spring Data repositories
├── service/      Business logic and transactions
└── controller/   REST endpoints and local error handling
```

Before refactoring structure, verify the existing package organization and preserve it unless the user explicitly requests a refactor.

## Development Flow

- Develop each microservice by layers in this order: **entity/model first**, then **service**, then **controller**.
- Keep controllers thin; business rules belong in services, and persistence details belong in repositories/entities.
- Prefer constructor injection for required dependencies.
- Use Lombok on entities as established in the codebase.
- Prefer UUID primary keys for microservice-owned entities unless existing code or documentation deliberately says otherwise.

## Documentation and Database Rules

- Check `.docs/functional-requirements.md` for business requirements (RF-01 to RF-28) before implementing related features.
- Do not modify `.docs/functional-requirements.md` unless the user explicitly asks.
- Check `.docs/db-architecture.md` before making persistence decisions.
- `.docs/db-architecture.md` should document current entity names unless a deliberate code refactor is made first.
- Keep `.docs/kafka-architecture.md` empty until the user decides to work on Kafka/messaging.
- Use `data.sql` for seed data with `INSERT` statements only.
- Do not add DDL, constraints, indexes, `CREATE TABLE`, `DROP TABLE`, or schema management to `data.sql` unless explicitly requested.

## API Gateway and Error Handling

- `api-gateway` handles routes that do not exist at the Gateway level.
- Each microservice handles its own domain errors and local invalid routes.
- Do not centralize or rewrite downstream domain `404` responses in `api-gateway`.
- Gateway routing changes must stay aligned with existing microservice endpoints.

## Tests, Builds, and Commands

- Do not create tests.
- Do not implement tests.
- Do not run tests.
- Do not run builds.
- Do not run package commands.
- Existing Spring Initializr test files may remain, but do not use, expand, or rely on them unless the user explicitly changes this rule.

## Do Not

- Do not implement Kafka yet.
- Do not implement Spring Security/JWT yet.
- Do not implement Testcontainers yet.
- Do not expand API Gateway infrastructure unless explicitly requested.
- Do not assume planned architecture pieces are already active in the current codebase.
- Do not add AI attribution or `Co-Authored-By` lines to commits.

## Agent Behavior for This Repo

- Verify the existing code before claiming something is implemented.
- Never agree with a technical claim without verification; check code or docs first.
- If the user is wrong, explain why with evidence. If you were wrong, acknowledge it with proof.
- Keep recommendations aligned with the current phase of the project, not the full future architecture.
- When adding or changing code, respect current package organization unless the user explicitly requests a refactor.
- Treat planned services and deferred infrastructure as roadmap context, not as permission to implement them.
