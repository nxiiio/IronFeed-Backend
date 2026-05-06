package cl.worellana.api_gateway.controller;

import cl.worellana.api_gateway.model.dto.ExceptionResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.webmvc.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayErrorController implements ErrorController {

    private static final String NOT_FOUND = "NOT_FOUND";
    private static final String NOT_FOUND_MESSAGE = "No se encontró el recurso solicitado";
    private static final String INTERNAL_ERROR = "INTERNAL_ERROR";
    private static final String INTERNAL_ERROR_MESSAGE = "Error procesando la solicitud";

    @RequestMapping("/error")
    public ResponseEntity<ExceptionResponse> handleError(HttpServletRequest request) {
        HttpStatus status = resolveStatus(request);
        String path = resolveOriginalPath(request);

        if (status == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ExceptionResponse(
                            HttpStatus.NOT_FOUND.value(),
                            NOT_FOUND,
                            NOT_FOUND_MESSAGE,
                            path,
                            null));
        }

        return ResponseEntity.status(status)
                .body(new ExceptionResponse(
                        status.value(),
                        INTERNAL_ERROR,
                        INTERNAL_ERROR_MESSAGE,
                        path,
                        null));
    }

    private HttpStatus resolveStatus(HttpServletRequest request) {
        Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (statusCode instanceof Integer status) {
            HttpStatus resolved = HttpStatus.resolve(status);
            if (resolved != null) {
                return resolved;
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private String resolveOriginalPath(HttpServletRequest request) {
        Object path = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        if (path instanceof String originalPath) {
            return originalPath;
        }
        return request.getRequestURI();
    }
}
