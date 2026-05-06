package cl.worellana.social_ms.exception;

public class SelfFollowNotAllowedException extends RuntimeException {

    public SelfFollowNotAllowedException() {
        super("Un usuario no puede seguirse a sí mismo.");
    }
}
