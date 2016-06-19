package br.com.challenge.view;

import br.com.challenge.infrastructure.exception.ApplicationException;
import br.com.challenge.view.presentation.dto.ErrorDto;
import br.com.challenge.view.presentation.dto.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles all application exceptions, displaying the appropriate payload
 */
@ControllerAdvice
public class ViewExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Resource> handleExceptions(HttpServletRequest request, ApplicationException exception) {
        ErrorDto errorDto = new ErrorDto(exception.getCode(), exception.getMessage());

        Resource<ErrorDto> resource = new Resource<>(request.getRequestURI(), errorDto);

        return new ResponseEntity<Resource>(resource, exception.getHttpStatus());
    }

}
