package cl.worellana.users_ms.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException() {
        super("El correo electrónico ya está en uso");
    }
}
