package cl.worellana.api_gateway.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ExceptionResponse(
        int status,
        String error,
        String message,
        String path,
        Map<String, String> fieldErrors
) {
}
