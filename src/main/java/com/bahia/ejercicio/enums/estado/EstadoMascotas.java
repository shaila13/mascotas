package com.bahia.ejercicio.enums.estado;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum EstadoMascotas {


    INGRESADO("Ingresado"),
    ALTA("Alta");

    String estado;

    String estado() {
        return estado;
    }
}