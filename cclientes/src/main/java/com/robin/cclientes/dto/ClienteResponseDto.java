package com.robin.cclientes.dto;

public record ClienteResponseDto(
        String nombre,
        String paterno,
        String correo,
        String direccion,
        String telefono
) {
}
