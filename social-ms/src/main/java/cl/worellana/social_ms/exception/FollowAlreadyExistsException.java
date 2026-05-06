package cl.worellana.social_ms.exception;

public class FollowAlreadyExistsException extends RuntimeException {

    public FollowAlreadyExistsException() {
        super("Ya existe una relación de seguimiento entre estos usuarios.");
    }
}
