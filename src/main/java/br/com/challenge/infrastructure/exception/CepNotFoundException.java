package br.com.challenge.infrastructure.exception;

public class CepNotFoundException extends ApplicationException {

    public CepNotFoundException() {
        super(ApplicationExceptionEnum.CEP_NOT_FOUND_EXCEPTION);
    }
}
