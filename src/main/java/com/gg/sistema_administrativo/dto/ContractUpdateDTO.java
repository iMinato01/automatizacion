package com.gg.sistema_administrativo.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class ContractUpdateDTO {
    @NotNull(message = "El nombre no puede estar vacío")
    private String name;
    @NotNull(message = "El status no puede estar vacío")
    private boolean status;
    @NotNull(message = "El monto no puede estar vacío")
    @DecimalMin(value = "0.0", message = "El valor debe ser número positivo")
    private float totalExpenses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(float totalExpenses) {
        this.totalExpenses = totalExpenses;
    }
}
