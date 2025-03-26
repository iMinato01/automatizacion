package com.gg.sistema_administrativo.global;

import com.gg.sistema_administrativo.exception.ContractAlreadyExistsException;
import com.gg.sistema_administrativo.exception.ContractNotFoundException;
import com.gg.sistema_administrativo.exception.ErrorResponse;
import com.gg.sistema_administrativo.exception.PropertyAlreadyInUseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ContractAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleContractAlreadyExists(ContractAlreadyExistsException ex){
        ErrorResponse error = new ErrorResponse(ex.getMessage(), "El contrato ya existe");
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ContractNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleContractNotFound(ContractNotFoundException ex){
        ErrorResponse error = new ErrorResponse(ex.getMessage(), "El contrato no existe");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PropertyAlreadyInUseException.class)
    public ResponseEntity<ErrorResponse> handlePropertyAlreadyInUse(PropertyAlreadyInUseException ex){
        ErrorResponse error = new ErrorResponse(ex.getMessage(), "La propiedad ya se encuentra en uso");
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
