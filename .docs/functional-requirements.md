# Requisitos Funcionales — IronFeed

---

## 👤 Gestión de Usuarios

| ID | Requerimiento | Descripción |
|----|--------------|-------------|
| RF-01 | Registro de usuario | El sistema debe permitir registrar un nuevo usuario con nombre de usuario, correo electrónico y contraseña. |
| RF-02 | Inicio de sesión | El sistema debe autenticar al usuario mediante sus credenciales y emitir un token de acceso para las solicitudes posteriores. |
| RF-03 | Configuración del perfil personal | El usuario puede actualizar su información personal: nombre, biografía y objetivos de entrenamiento. |
| RF-04 | Registro de métricas corporales | El sistema debe permitir al usuario registrar métricas corporales (peso, porcentaje de grasa) y consultar su historial. |

---

## 🏋️ Entrenamientos

| ID | Requerimiento | Descripción |
|----|--------------|-------------|
| RF-05 | Creación de rutinas | El usuario puede crear rutinas definiendo ejercicios, series, repeticiones y cargas. |
| RF-06 | Registro de sesión completada | El sistema debe permitir registrar una sesión de entrenamiento completada, asociada a una rutina previa o creada en el momento. |
| RF-07 | Detección automática de récord personal | Al guardar una sesión, el sistema compara los resultados con el historial previo y registra si algún ejercicio alcanzó un nuevo máximo. |

---

## 📣 Publicaciones

| ID | Requerimiento | Descripción |
|----|--------------|-------------|
| RF-08 | Publicación manual de contenido | El usuario puede publicar tres tipos de contenido: entrenamiento completado, récord personal o foto de progreso físico. |
| RF-09 | Publicación automática por récord | Cuando el sistema detecta un nuevo récord, genera automáticamente una publicación en nombre del usuario. |
| RF-10 | Reacciones a publicaciones | Los usuarios pueden reaccionar a publicaciones de otros dentro de su red. |
| RF-11 | Comentarios en publicaciones | Los usuarios pueden comentar publicaciones de otros dentro de su red. |

---

## 📰 Feed Social

| ID | Requerimiento | Descripción |
|----|--------------|-------------|
| RF-12 | Visualización del feed personalizado | El sistema muestra al usuario el contenido publicado por las personas que sigue, ordenado por fecha descendente. |
| RF-13 | Distribución en tiempo real al feed | Cada publicación nueva se distribuye al feed de todos los seguidores del autor en el momento en que se publica. |

---

## 🔗 Seguimiento Social

| ID | Requerimiento | Descripción |
|----|--------------|-------------|
| RF-14 | Seguir a otro usuario | El usuario puede seguir a otros. Al hacerlo, sus publicaciones comenzarán a aparecer en el feed. |
| RF-15 | Dejar de seguir a un usuario | El usuario puede dejar de seguir a otro. Sus publicaciones dejarán de aparecer en el feed. |
| RF-16 | Búsqueda de usuarios | El sistema debe permitir buscar otros usuarios por nombre de usuario para poder seguirlos. |

---

## 🏆 Retos

| ID | Requerimiento | Descripción |
|----|--------------|-------------|
| RF-17 | Creación de reto | Cualquier usuario puede crear un reto definiendo nombre, tipo de actividad, meta cuantificable y período de tiempo. |
| RF-18 | Inscripción en reto | El usuario puede inscribirse en retos activos disponibles en la plataforma. |
| RF-19 | Seguimiento automático de progreso | El progreso en un reto se actualiza automáticamente a partir de los entrenamientos registrados, sin reporte manual. |
| RF-20 | Validación y cierre de reto | Cuando el progreso alcanza la meta dentro del plazo, el sistema valida el cumplimiento y notifica al participante. |

---

## 📊 Rankings

| ID | Requerimiento | Descripción |
|----|--------------|-------------|
| RF-21 | Ranking por volumen semanal | El sistema mantiene un ranking por volumen total de entrenamiento semanal, actualizado con cada sesión registrada. |
| RF-22 | Ranking por racha de días activos | El sistema mantiene un ranking por días consecutivos con al menos una sesión registrada. |
| RF-23 | Ranking por récord en ejercicio | El sistema permite consultar el ranking de mejores marcas personales por ejercicio específico en la comunidad. |
| RF-24 | Consulta de posición propia | El usuario puede consultar su posición actual dentro de cada ranking desde su perfil. |

---

## 🔔 Notificaciones

| ID | Requerimiento | Descripción |
|----|--------------|-------------|
| RF-25 | Notificación por interacción en publicación | El usuario recibe una notificación en tiempo real cuando alguien reaccione o comente una de sus publicaciones. |
| RF-26 | Notificación por nuevo seguidor | El sistema notifica al usuario cuando alguien comience a seguirlo. |
| RF-27 | Notificación por récord de contacto | El sistema notifica al usuario cuando alguien de su red rompa un récord personal. |
| RF-28 | Notificación por resultado de reto | El sistema notifica al usuario cuando un reto en que participa llega a su fin, indicando si cumplió la meta o no. |