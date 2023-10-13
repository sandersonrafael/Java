package com.cursojava.spring.services.exceptions;

// erro personalizado que extende do RuntimeException e dá mensagem personalizada também
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }
}
