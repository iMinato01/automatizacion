package com.gg.sistema_administrativo.exception;

public class ContractAlreadyExistsException extends RuntimeException{
    public ContractAlreadyExistsException(String message){
        super(message);
    }
}
