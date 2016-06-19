package br.com.challenge.infrastructure.exception;

import org.springframework.http.HttpStatus;

/**
 * A generic application exception
 */
public class ApplicationException extends RuntimeException {

    private String code;
    private String message;
    private HttpStatus httpStatus;

    public ApplicationException(ApplicationExceptionEnum applicationExceptionEnum) {
        super();
        this.code = applicationExceptionEnum.getCode();
        this.message = applicationExceptionEnum.getMessage();
        this.httpStatus = applicationExceptionEnum.getHttpStatus();
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
