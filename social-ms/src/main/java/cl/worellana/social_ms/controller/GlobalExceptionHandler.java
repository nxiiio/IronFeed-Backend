package cl.worellana.social_ms.controller;

import cl.worellana.social_ms.exception.FollowAlreadyExistsException;
import cl.worellana.social_ms.exception.FollowNotFoundException;
import cl.worellana.social_ms.exception.SelfFollowNotAllowedException;
import cl.worellana.social_ms.model.dto.response.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest req) {
        Map<String, String> fields = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(fe -> fields.put(fe.getField(), fe.getDefaultMessage()));
        return build(HttpStatus.BAD_REQUEST, "VALIDATION_ERROR", "Datos de entrada inválidos", req, fields);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex, HttpServletRequest req) {
        String requiredType = ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "valor válido";
        String message = "El valor '" + ex.getValue() + "' no es un " + requiredType + " válido";
        return build(HttpStatus.BAD_REQUEST, "BAD_REQUEST", "Parámetro inválido", req,
                Map.of(ex.getName(), message));
    }

    @ExceptionHandler(SelfFollowNotAllowedException.class)
    public ResponseEntity<ExceptionResponse> handleSelfFollow(SelfFollowNotAllowedException ex, HttpServletRequest req) {
        return build(HttpStatus.BAD_REQUEST, "BAD_REQUEST", ex.getMessage(), req, null);
    }

    @ExceptionHandler(FollowAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleFollowAlreadyExists(FollowAlreadyExistsException ex, HttpServletRequest req) {
        return build(HttpStatus.CONFLICT, "CONFLICT", ex.getMessage(), req, null);
    }

    @ExceptionHandler(FollowNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleFollowNotFound(FollowNotFoundException ex, HttpServletRequest req) {
        return build(HttpStatus.NOT_FOUND, "NOT_FOUND", ex.getMessage(), req, null);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponse> handleConflict(DataIntegrityViolationException ex, HttpServletRequest req) {
        return build(HttpStatus.CONFLICT, "CONFLICT", "Violación de integridad de datos", req, null);
    }

    @ExceptionHandler({NoHandlerFoundException.class, NoResourceFoundException.class})
    public ResponseEntity<ExceptionResponse> handleRouteNotFound(Exception ex, HttpServletRequest req) {
        return build(HttpStatus.NOT_FOUND, "NOT_FOUND", "No se encontró el recurso solicitado", req, null);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleGeneric(Exception ex, HttpServletRequest req) {
        return build(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_ERROR", "Error interno del servidor", req, null);
    }

    private ResponseEntity<ExceptionResponse> build(HttpStatus status, String code, String message,
                                                    HttpServletRequest req, Map<String, String> fieldErrors) {
        ExceptionResponse body = ExceptionResponse.builder()
                .status(status.value())
                .error(code)
                .message(message)
                .path(req.getRequestURI())
                .fieldErrors(fieldErrors)
                .build();
        return ResponseEntity.status(status).body(body);
    }
}
