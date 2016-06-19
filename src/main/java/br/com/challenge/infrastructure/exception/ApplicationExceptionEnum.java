package br.com.challenge.infrastructure.exception;

import org.springframework.http.HttpStatus;

/**
 * Enum representing all {@link ApplicationException} attributes
 */
public enum ApplicationExceptionEnum {
    CEP_NOT_FOUND_EXCEPTION("404", "CEP não encontrado", HttpStatus.NOT_FOUND),
    INVALID_CEP_EXCEPTION("400", "CEP inválido", HttpStatus.BAD_REQUEST);

    private String code;
    private String message;
    private HttpStatus httpStatus;

    ApplicationExceptionEnum(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
