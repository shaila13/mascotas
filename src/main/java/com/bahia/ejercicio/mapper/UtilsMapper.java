package com.bahia.ejercicio.mapper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.bahia.ejercicio.dto.MascotaDto;
import com.bahia.ejercicio.model.Animal;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UtilsMapper {

	public Map<Integer, MascotaDto> animalesEntitiesToDtos(Map<Integer, Animal> entities) {
		
		Map<Integer, MascotaDto> mascotasMap = new HashMap<>(); 
		entities.forEach((idMascota,animal) -> mascotasMap.put(idMascota,animalEntityToDto(animal)));	
		return mascotasMap;
               
	}
	
	public MascotaDto animalEntityToDto(Animal entity) {
		return MascotaDto.builder().animal(entity).build();
	}
}
