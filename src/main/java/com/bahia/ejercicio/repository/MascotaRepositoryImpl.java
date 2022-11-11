package com.bahia.ejercicio.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.bahia.ejercicio.enums.estado.DescripcionAnimal;
import com.bahia.ejercicio.enums.estado.EstadoMascotas;
import com.bahia.ejercicio.model.Animal;
import com.bahia.ejercicio.model.Gato;
import com.bahia.ejercicio.model.Perro;
import com.bahia.ejercicio.model.Propietario;

@Repository
public class MascotaRepositoryImpl implements MascotaRepository{

	private Map<Integer, Animal>cargaInicialDatos = this.cargaInicialDatos();
	
	@Override
	public Map<Integer, Animal> findAll() {
		return this.cargaInicialDatos;
	}

	@Override
	public Animal getMascotaById(Integer id) {
		Map<Integer, Animal> animales = this.findAll();
		
		Optional<Animal> animal = animales.entrySet().stream()
				  .filter(a -> id.equals(a.getKey()))
				  .map(Map.Entry::getValue)
				  .findFirst();
		
		return animal.isPresent() ? animal.get() : null;
	}

	private Map<Integer, Animal> cargaInicialDatos() {
		Map<Integer, Animal> animales = new HashMap<>();
				
		Perro perro1 = new Perro(1,"Boby",EstadoMascotas.INGRESADO.toString(),LocalDate.now(),1,Propietario.builder().idPropietario(1).nombre("Shaila").apellidos("Perez Fernandez").build() ,DescripcionAnimal.PERRO.toString());
	
		Perro perro2 = new Perro(2,"Lassie",EstadoMascotas.ALTA.toString(),LocalDate.now(),5, Propietario.builder().idPropietario(2).nombre("Mary").apellidos("Fernandez Perez").build(),DescripcionAnimal.PERRO.toString());
		
		Perro perro3 = new Perro(3,"Luna",EstadoMascotas.INGRESADO.toString(),LocalDate.now(),3,Propietario.builder().idPropietario(3).nombre("Alejandro").apellidos("Perez Castelao").build(),DescripcionAnimal.PERRO.toString());

		Gato gato1 = new Gato(4,"Carni",EstadoMascotas.ALTA.toString(),LocalDate.now(),4,Propietario.builder().idPropietario(4).nombre("Eduardo").apellidos("Alvarez Haro").build(),DescripcionAnimal.GATO.toString());	
				
		Gato gato2 = new Gato(5,"Merlin",EstadoMascotas.INGRESADO.toString(),LocalDate.now(),2,Propietario.builder().idPropietario(5).nombre("Luis").apellidos("Alvarez Garcia").build(),DescripcionAnimal.GATO.toString());				
 
		Gato gato3 = new Gato(6,"Charly",EstadoMascotas.ALTA.toString(),LocalDate.now(),9,Propietario.builder().idPropietario(6).nombre("Ana").apellidos("Garcia Lopez").build(),DescripcionAnimal.GATO.toString());

		animales.put(perro1.getIdAnimal(), perro1);
		animales.put(perro2.getIdAnimal(), perro2);
		animales.put(perro3.getIdAnimal(), perro3);
		animales.put(gato1.getIdAnimal(), gato1);
		animales.put(gato2.getIdAnimal(), gato2);
		animales.put(gato3.getIdAnimal(), gato3);
		
		return animales;
	}
}
