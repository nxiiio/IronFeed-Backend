package cl.worellana.users_ms.exception;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException() {
        super("El nombre de usuario ya está en uso");
    }
}
