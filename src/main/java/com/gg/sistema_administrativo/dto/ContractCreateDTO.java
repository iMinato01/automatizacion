package com.gg.sistema_administrativo.dto;

import jakarta.validation.constraints.NotBlank;

public class ContractCreateDTO {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
