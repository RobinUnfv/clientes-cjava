package com.robin.mclientes.model;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Cliente {

    @Id
    private String id;
    private String nombre;
    private String paterno;
    private String correo;
    private String direccion;
    private String telefono;

}
