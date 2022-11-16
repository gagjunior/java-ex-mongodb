package br.com.gagjunior.ex.mongodb.resources.exceptions;

import br.com.gagjunior.ex.mongodb.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        Instant timestamp = Instant.now();
        HttpStatus status = HttpStatus.NOT_FOUND;
        String msg = "Não encontrado";
        String msgError = e.getMessage();
        StandardError error = new StandardError(timestamp, status.value(), msg, msgError, request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
