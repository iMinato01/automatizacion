package com.gg.sistema_administrativo.exception;

public class PropertyAlreadyInUseException extends RuntimeException{
    public PropertyAlreadyInUseException(String message){
        super(message);
    }
}
