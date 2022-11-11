package com.bahia.ejercicio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bahia.ejercicio.dto.MascotaResponse;
import com.bahia.ejercicio.dto.MascotasResponse;
import com.bahia.ejercicio.enums.estado.EstadoMascotas;
import com.bahia.ejercicio.service.MascotaService;

@RestController
@RequestMapping("/api")
public class ApplicationController {

	@Autowired
	private MascotaService mascotaService;


	@GetMapping("/mascotas")
	public ResponseEntity<MascotasResponse> getAllMascotas() {
		return ResponseEntity.ok(mascotaService.getAllMascotas());
	}

	@GetMapping("/mascota/{id}")
	public ResponseEntity<MascotaResponse> getMascotasById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(mascotaService.getMascotaById(id));
	}

	@GetMapping("/mascotas/{estado}")
	public ResponseEntity<MascotasResponse> getMascotasByEstado(@PathVariable("estado") String estado) {
		return ResponseEntity.ok(mascotaService.getMascotaByEstado(estado));
	}


}
