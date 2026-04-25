# IronFeed — Contexto del Proyecto

## ¿Qué es IronFeed?

IronFeed es una red social enfocada en fitness, desarrollada íntegramente como un sistema **solo backend** usando arquitectura de **microservicios + Event-Driven**. No hay frontend; toda la interacción ocurre a través de APIs REST y eventos asíncronos.

El problema que resuelve es concreto: los usuarios de fitness hoy usan varias aplicaciones para registrar entrenamientos, hacer seguimiento de su progreso y compartir logros, sin conseguir una experiencia integrada ni una comunidad especializada. IronFeed centraliza todo esto en una sola plataforma donde la constancia y los logros tienen visibilidad real dentro de una comunidad dedicada exclusivamente al entrenamiento.

---

## Arquitectura

- **Estilo:** Microservicios + Event-Driven Architecture (EDA)
- **Comunicación:** Sincrónica (REST vía API Gateway) + Asíncrona (Apache Kafka para eventos entre servicios)
- **Cada microservicio tiene su propia base de datos PostgreSQL** — sin bases de datos compartidas
- **API Gateway:** punto de entrada único para todas las solicitudes
- **Autenticación:** tokens JWT emitidos por el servicio de Usuarios

### Stack Tecnológico

| Capa | Tecnología |
|---|---|
| Lenguaje | Java |
| Framework | Spring Boot |
| Mensajería | Apache Kafka |
| Base de datos | PostgreSQL (una por microservicio) |
| Gateway | Spring Cloud Gateway |
| Auth | JWT |
| Contenedores | Docker / Docker Compose |
| Testing | Testcontainers |
| Build | Maven |

---

## Microservicios (8 en total)

Cada servicio es un despliegue independiente. La comunicación entre servicios se realiza por Kafka salvo que se indique lo contrario.

| # | Servicio | Responsabilidad |
|---|---|---|
| 1 | **Usuarios** | Registro, autenticación, perfil y métricas corporales |
| 2 | **Entrenamientos** | Rutinas, sesiones completadas y detección de récords personales |
| 3 | **Publicaciones** | Posts (entrenamientos, récords, fotos de progreso), reacciones y comentarios |
| 4 | **Feed Social** | Feed personalizado por usuario y distribución en tiempo real |
| 5 | **Seguimiento Social** | Relaciones follow/unfollow y búsqueda de usuarios |
| 6 | **Retos** | Creación de retos, inscripción y seguimiento automático de progreso |
| 7 | **Rankings** | Ranking por volumen semanal, racha de días activos y récord por ejercicio |
| 8 | **Notificaciones** | Notificaciones en tiempo real por interacciones, seguimientos, récords y retos |

---

## Restricciones Importantes

- **Sin frontend** — proyecto puramente backend
- **Sin rol administrador** — un único tipo de actor: el usuario
- **Cada microservicio tiene su propia BD** — sin joins entre servicios; consistencia vía eventos
- **Los récords personales se detectan automáticamente** por el servicio de Entrenamientos, no los reporta el usuario
- **El progreso en retos se actualiza automáticamente** a partir de las sesiones registradas, sin reporte manual
- **La distribución del feed es push** — impulsada por eventos Kafka, no por polling