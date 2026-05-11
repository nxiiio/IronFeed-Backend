package cl.worellana.posts_ms.exception;

public class ReactionAlreadyExistsException extends RuntimeException {

    public ReactionAlreadyExistsException() {
        super("El usuario ya reaccionó a esta publicación.");
    }
}
