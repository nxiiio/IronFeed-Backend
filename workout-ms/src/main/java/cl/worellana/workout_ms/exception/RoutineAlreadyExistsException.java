package cl.worellana.workout_ms.exception;

public class RoutineAlreadyExistsException extends RuntimeException {

    public RoutineAlreadyExistsException() {
        super("Ya existe una rutina con ese nombre para este usuario.");
    }
}
