package com.gg.sistema_administrativo.global;

import com.gg.sistema_administrativo.exception.EntityAlreadyExistsException;
import com.gg.sistema_administrativo.exception.EntityNotFoundException;
import com.gg.sistema_administrativo.exception.ErrorResponse;
import com.gg.sistema_administrativo.exception.PropertyAlreadyInUseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleContractAlreadyExists(EntityAlreadyExistsException ex){
        ErrorResponse error = new ErrorResponse(ex.getMessage(), "La entidad ya existe");
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleContractNotFound(EntityNotFoundException ex){
        ErrorResponse error = new ErrorResponse(ex.getMessage(), "La entidad no está registrada");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PropertyAlreadyInUseException.class)
    public ResponseEntity<ErrorResponse> handlePropertyAlreadyInUse(PropertyAlreadyInUseException ex){
        ErrorResponse error = new ErrorResponse(ex.getMessage(), "La propiedad ya se encuentra en uso");
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
