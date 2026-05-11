package cl.worellana.posts_ms.exception;

public class CommentNotFoundException extends RuntimeException {

    public CommentNotFoundException() {
        super("Comentario no encontrado.");
    }
}
