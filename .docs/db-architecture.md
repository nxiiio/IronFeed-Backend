# IronFeed — Documentación de Base de Datos

---

## MS Gestión de Usuarios

### `app_user`
| Columna | Tipo |
|---|---|
| `user_id` (PK) | UUID |
| `username` | VARCHAR(50) |
| `email` | VARCHAR(100) |
| `password_hash` | VARCHAR(255) |
| `full_name` | VARCHAR(100) |
| `bio` | VARCHAR(4000) |

---

## MS Entrenamientos

### `exercise`
| Columna | Tipo |
|---|---|
| `exercise_id` (PK) | UUID |
| `name` | VARCHAR(100) |
| `muscle_group` | VARCHAR(50) |
| `description` | VARCHAR(4000) |

### `routine`
| Columna | Tipo |
|---|---|
| `routine_id` (PK) | UUID |
| `user_id` (FK → app_user) | UUID |
| `name` | VARCHAR(100) |
| `description` | VARCHAR(4000) |

### `workout_session`
| Columna | Tipo |
|---|---|
| `session_id` (PK) | UUID |
| `user_id` (FK → app_user) | UUID |
| `routine_id` (FK → routine) | UUID |
| `started_at` | TIMESTAMP |
| `finished_at` | TIMESTAMP |
| `notes` | VARCHAR(4000) |

### `personal_record`
| Columna | Tipo |
|---|---|
| `record_id` (PK) | UUID |
| `user_id` (FK → app_user) | UUID |
| `exercise_id` (FK → exercise) | UUID |
| `session_id` (FK → workout_session) | UUID |
| `weight_kg` | NUMERIC(5,2) |
| `reps` | INTEGER |
| `achieved_at` | TIMESTAMP |

---

## MS Publicaciones

### `post`
| Columna | Tipo |
|---|---|
| `post_id` (PK) | UUID |
| `user_id` (FK → app_user) | UUID |
| `workout_session_id` (FK → workout_session) | UUID |
| `personal_record_id` (FK → personal_record) | UUID |
| `caption` | VARCHAR(4000) |
| `image_url` | VARCHAR(255) |

### `reaction`
| Columna | Tipo |
|---|---|
| `reaction_id` (PK) | UUID |
| `post_id` (FK → post) | UUID |
| `user_id` (FK → app_user) | UUID |

### `comment`
| Columna | Tipo |
|---|---|
| `comment_id` (PK) | UUID |
| `post_id` (FK → post) | UUID |
| `user_id` (FK → app_user) | UUID |
| `content` | VARCHAR(4000) |

---

## MS Feed Social

> Sin tablas propias. Consume eventos Kafka de **Publicaciones** y **Seguimiento Social** para construir el feed en tiempo real.

---

## MS Seguimiento Social

### `follow`
| Columna | Tipo |
|---|---|
| `follow_id` (PK) | UUID |
| `follower_user_id` (FK → app_user) | UUID |
| `following_user_id` (FK → app_user) | UUID |

---

## MS Retos

### `challenge_status` *(catálogo)*
| Columna | Tipo |
|---|---|
| `status_id` (PK) | BIGINT |
| `name` | VARCHAR(20) |

**Valores:** `ACTIVE`, `CLOSED`, `CANCELLED`

### `challenge`
| Columna | Tipo |
|---|---|
| `challenge_id` (PK) | UUID |
| `creator_user_id` (FK → app_user) | UUID |
| `status_id` (FK → challenge_status) | BIGINT |
| `title` | VARCHAR(150) |
| `description` | VARCHAR(4000) |
| `goal_value` | NUMERIC(10,2) |
| `goal_unit` | VARCHAR(30) |
| `start_date` | DATE |
| `end_date` | DATE |

### `challenge_participant`
| Columna | Tipo |
|---|---|
| `participant_id` (PK) | UUID |
| `challenge_id` (FK → challenge) | UUID |
| `user_id` (FK → app_user) | UUID |
| `joined_at` | TIMESTAMP |
| `current_progress` | NUMERIC(10,2) |
| `is_completed` | BOOLEAN |
| `completed_at` | TIMESTAMP |

---

## MS Rankings

### `weekly_volume_ranking`
| Columna | Tipo |
|---|---|
| `ranking_id` (PK) | UUID |
| `user_id` (FK → app_user) | UUID |
| `week_start` | DATE |
| `total_volume_kg` | NUMERIC(10,2) |
| `rank_position` | INTEGER |

---

## MS Notificaciones

### `notification_type` *(catálogo)*
| Columna | Tipo |
|---|---|
| `notification_type_id` (PK) | BIGINT |
| `name` | VARCHAR(30) |

**Valores:** `REACTION`, `COMMENT`, `NEW_FOLLOWER`, `CONTACT_RECORD`, `CHALLENGE_RESULT`

### `notification`
| Columna | Tipo |
|---|---|
| `notification_id` (PK) | UUID |
| `recipient_user_id` (FK → app_user) | UUID |
| `notification_type_id` (FK → notification_type) | BIGINT |
| `post_id` (FK → post) | UUID |
| `challenge_id` (FK → challenge) | UUID |
| `title` | VARCHAR(150) |
| `body` | VARCHAR(4000) |
| `is_read` | BOOLEAN |

---

## Relaciones

### Dentro del mismo microservicio

| Tabla | Columna | Referencia |
|---|---|---|
| `routine` | `user_id` | `app_user.user_id` |
| `workout_session` | `user_id` | `app_user.user_id` |
| `workout_session` | `routine_id` | `routine.routine_id` |
| `personal_record` | `user_id` | `app_user.user_id` |
| `personal_record` | `exercise_id` | `exercise.exercise_id` |
| `personal_record` | `session_id` | `workout_session.session_id` |
| `post` | `post_id` | `reaction.post_id` |
| `post` | `post_id` | `comment.post_id` |
| `follow` | `follower_user_id` | `app_user.user_id` |
| `follow` | `following_user_id` | `app_user.user_id` |
| `challenge` | `status_id` | `challenge_status.status_id` |
| `challenge_participant` | `challenge_id` | `challenge.challenge_id` |
| `notification` | `notification_type_id` | `notification_type.notification_type_id` |

### Cross-servicio *(referenciales, sin FK en producción)*

| Tabla | Columna | Referencia |
|---|---|---|
| `post` | `user_id` | `app_user.user_id` |
| `post` | `workout_session_id` | `workout_session.session_id` |
| `post` | `personal_record_id` | `personal_record.record_id` |
| `reaction` | `user_id` | `app_user.user_id` |
| `comment` | `user_id` | `app_user.user_id` |
| `challenge` | `creator_user_id` | `app_user.user_id` |
| `challenge_participant` | `user_id` | `app_user.user_id` |
| `weekly_volume_ranking` | `user_id` | `app_user.user_id` |
| `notification` | `recipient_user_id` | `app_user.user_id` |
| `notification` | `post_id` | `post.post_id` |
| `notification` | `challenge_id` | `challenge.challenge_id` |