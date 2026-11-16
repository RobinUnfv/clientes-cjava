package com.robin.mclientes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClienteRequestDto(
        @NotBlank(message = "El nombre del cliente no puede estar vacío")
        String nombre,

        @NotBlank(message = "El Apellido del cliente no puede estar vacío")
        String paterno,

        @NotBlank(message = "El Correo del cliente no puede estar vacío")
        @Email(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
                message = "El correo no tiene un formato valido")
        String correo,

        @NotBlank(message = "La dirección del cliente no puede estar vacía")
        String direccion,

        @NotBlank(message = "El teléfono del cliente no puede estar vacío")
        @Pattern(regexp = "^\\d{9}$", message = "El telefono debe tener exactamente 9 digitos numericos")
        String telefono
) {
}
