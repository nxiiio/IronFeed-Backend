package cl.worellana.posts_ms.exception;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException() {
        super("Publicación no encontrada.");
    }
}
