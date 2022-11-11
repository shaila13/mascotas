package com.bahia.ejercicio.service;

import com.bahia.ejercicio.exception.ValidationException;

public interface IValidarDatosService {


	/**
	 * Se valida el id para realizar las operaciones de busqueda de una
	 * mascota.
	 * 
	 * @param id
	 * @throws ValidationException
	 */
	void validarIdMascota(Integer id) throws ValidationException;

	/**
	 * Se valida el estado para realizar la operacion de busqueda de uno o varios
	 * mascotas.
	 * 
	 * @param estado
	 * @throws ValidationException
	 */
	void validarEstadoBusquedaMascota(String estado) throws ValidationException;
}
