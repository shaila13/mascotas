package com.bahia.ejercicio.repository;

import java.util.Map;

import com.bahia.ejercicio.model.Animal;

public interface MascotaRepository {
	
	/**
	 * 
	 * @return Map<Integer, Animal>
	 */
	Map<Integer, Animal> findAll();
	
	/**
	 * 
	 * @param id
	 * @return Animal
	 */
	Animal getMascotaById(Integer id);
			
	
}
