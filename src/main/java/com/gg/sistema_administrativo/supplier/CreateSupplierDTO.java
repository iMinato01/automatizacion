package com.gg.sistema_administrativo.supplier;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateSupplierDTO {
    @NotBlank
    private String name;
    private String rfc;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String services;
    @NotBlank
    private boolean status;
}
