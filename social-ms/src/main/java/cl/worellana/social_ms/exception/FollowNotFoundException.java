package cl.worellana.social_ms.exception;

public class FollowNotFoundException extends RuntimeException {

    public FollowNotFoundException() {
        super("La relación de seguimiento no existe.");
    }
}
