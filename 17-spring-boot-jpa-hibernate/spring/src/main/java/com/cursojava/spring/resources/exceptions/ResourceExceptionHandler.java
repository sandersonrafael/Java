package com.cursojava.spring.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cursojava.spring.services.exceptions.DatabaseException;
import com.cursojava.spring.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // declara para o Jpa que trata-se de um aviso de erros do controller
public class ResourceExceptionHandler {

    // necessário criar um ResponseEntity<ClasseDeErro> com o erro criado
    @ExceptionHandler(ResourceNotFoundException.class)
    // ^ permite que a exceção informada dentro de parêntese, ao ser propagada, execute esse método a seguir
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND; // pega um objeto do tipo http status
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST; // pega um objeto do tipo http status
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
