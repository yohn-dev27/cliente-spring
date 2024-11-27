package com.prueba.cliente_api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Genera setter y getter de todos los atributos de la clase
@AllArgsConstructor //Constructor con los parametros
@NoArgsConstructor //Constructor sin parametro
public class Cliente {

    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String direccion;
    private String ciudad;
    //@Builder.Default
    private String mensaje;
}


