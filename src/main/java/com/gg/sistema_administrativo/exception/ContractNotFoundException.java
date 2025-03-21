package com.gg.sistema_administrativo.exception;

public class ContractNotFoundException extends RuntimeException{
    public ContractNotFoundException(String message){
        super(message);
    }
}
