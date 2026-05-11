package cl.worellana.posts_ms.exception;

public class ReactionNotFoundException extends RuntimeException {

    public ReactionNotFoundException() {
        super("La reacción no existe.");
    }
}
