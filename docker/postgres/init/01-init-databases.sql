-- users-ms
CREATE USER users_user WITH PASSWORD 'users_pass';
CREATE DATABASE users_db OWNER users_user;
GRANT ALL PRIVILEGES ON DATABASE users_db TO users_user;

-- workout-ms
CREATE USER workout_user WITH PASSWORD 'workout_pass';
CREATE DATABASE workout_db OWNER workout_user;
GRANT ALL PRIVILEGES ON DATABASE workout_db TO workout_user;
