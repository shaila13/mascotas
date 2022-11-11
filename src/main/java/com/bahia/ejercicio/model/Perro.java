package com.bahia.ejercicio.model;


import java.time.LocalDate;

import com.bahia.ejercicio.enums.estado.DescripcionAnimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Perro extends Animal {

	String especie;
	public Perro(Integer idMascota, String nombre, String estado, LocalDate fechaNacimiento, Integer numVisitas,
			Propietario propietario, String especie) {
		super(idMascota, nombre, estado, fechaNacimiento, numVisitas, propietario);
		this.especie = "Canis lupus familiaris";
	}

}
