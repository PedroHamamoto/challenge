package br.com.challenge.infrastructure.exception;

public class InvalidCepException extends ApplicationException {
    public InvalidCepException() {
        super(ApplicationExceptionEnum.INVALID_CEP_EXCEPTION);
    }
}
