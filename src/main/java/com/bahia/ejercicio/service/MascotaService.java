package com.bahia.ejercicio.service;

import com.bahia.ejercicio.dto.MascotaResponse;
import com.bahia.ejercicio.dto.MascotasResponse;

public interface MascotaService {

	/**
	 * Devuelve una lista de mascotas.
	 * 
	 * @return MascotaResponse
	 */
	MascotasResponse getAllMascotas();

	/**
	 * Devuelve una Mascota por id.
	 * 
	 * @param id
	 * @return MascotaResponse
	 * 
	 */
	MascotaResponse getMascotaById(Integer id);

	/**
	 * Devuelve una lista de Mascotas por estado.
	 * 
	 * @param estado
	 * @return MascotaResponse
	 */
	MascotasResponse getMascotaByEstado(String estado);
}
