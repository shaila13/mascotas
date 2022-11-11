package com.bahia.ejercicio.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bahia.ejercicio.dto.MascotaDto;
import com.bahia.ejercicio.dto.MascotaResponse;
import com.bahia.ejercicio.dto.MascotasResponse;
import com.bahia.ejercicio.exception.MascotaNotFoundException;
import com.bahia.ejercicio.exception.ValidationException;
import com.bahia.ejercicio.mapper.UtilsMapper;
import com.bahia.ejercicio.model.Animal;
import com.bahia.ejercicio.repository.MascotaRepository;
import com.bahia.ejercicio.service.IValidarDatosService;
import com.bahia.ejercicio.service.MascotaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MascotaServiceImpl implements MascotaService {

	private final MascotaRepository mascotaRepository;

	private final IValidarDatosService validarDatos;

	private final UtilsMapper utilsMapper;
	
		
	public MascotaServiceImpl(MascotaRepository mascotaRepository,IValidarDatosService validarDatos, 
			UtilsMapper utilsMapper) {
		this.mascotaRepository = mascotaRepository;
		this.validarDatos = validarDatos;
		this.utilsMapper = utilsMapper;
	}
	

	@Override
	public MascotasResponse getAllMascotas() {
		Map<Integer, Animal> mascotasEntities = mascotaRepository.findAll();
		return MascotasResponse.builder().mascotaMap(utilsMapper.animalesEntitiesToDtos(mascotasEntities)).build();
	}

	@Override
	public MascotaResponse getMascotaById(Integer id) {
		Animal animal = Animal.builder().build();
		
		try {
			validarDatos.validarIdMascota(id);

			animal = mascotaRepository.getMascotaById(id);
		} catch (ValidationException e) {
			log.error("Los datos son obligatorios.", e.getMessage());
		} catch (MascotaNotFoundException e) {
			log.error("MascotaNotFoundException ", e.getMessage());
		}
		return MascotaResponse.builder().mascota(utilsMapper.animalEntityToDto(animal)).build();
	}

	@Override
	public MascotasResponse getMascotaByEstado(String estado) {

		try {
			validarDatos.validarEstadoBusquedaMascota(estado);
		} catch (ValidationException e) {
			log.error("Los datos son obligatorios.", e.getMessage());
		}
		
		Map<Integer, Animal> mascotas = mascotaRepository.findAll();
		
		Map<Integer, MascotaDto> mascotasByEstado = new HashMap<>();
		
		for (Map.Entry<Integer, Animal> entry : mascotas.entrySet()) {
			if (estado.equals(entry.getValue().getEstado())) {
				mascotasByEstado.put(entry.getKey(), utilsMapper.animalEntityToDto(entry.getValue()));
			}
		}
	
		return MascotasResponse.builder().mascotaMap(mascotasByEstado).build();
	}

}
