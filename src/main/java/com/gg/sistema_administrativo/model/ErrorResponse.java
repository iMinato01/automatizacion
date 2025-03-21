package com.gg.sistema_administrativo.model;

public class ErrorResponse {
    private String error;
    private String details;
    public ErrorResponse(String error, String details){
        this.error = error;
        this.details = details;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
