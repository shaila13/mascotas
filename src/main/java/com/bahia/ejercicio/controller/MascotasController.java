package com.bahia.ejercicio.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bahia.ejercicio.service.MascotaService;

@Controller
public class MascotasController {

	@Autowired
	private MascotaService mascotaService;


	@GetMapping("/mascotas")
	public String mostrarTablaMascotas(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("INGRESADO");
		lista.add("ALTA");
		
		model.addAttribute("estado", lista);
		
		model.addAttribute("mascotas", mascotaService.getAllMascotas());
		return "mascotas";
	}
	
	@GetMapping("/mascota/{id}")
	public String getMascotasById(Model model,@PathVariable("id") Integer id) {
		model.addAttribute("mascota", mascotaService.getMascotaById(id));
		return "detalle";
	}
	
	@GetMapping("/mascotas/{estado}")
	public String getMascotasByEstado(Model model,@PathVariable("estado") String estado) {
		model.addAttribute("mascotas", mascotaService.getMascotaByEstado(estado));
		return "mascotasFiltrado";
	}
	
//	@GetMapping("/mascotas")
//	public ResponseEntity<MascotasResponse> getAllMascotas() {
//		return ResponseEntity.ok(mascotaService.getAllMascotas());
//	}

//	@GetMapping("/mascota/{id}")
//	public ResponseEntity<MascotaResponse> getMascotasById(@PathVariable("id") Integer id) {
//		return ResponseEntity.ok(mascotaService.getMascotaById(id));
//	}

//	@GetMapping("/mascotas/{estado}")
//	public ResponseEntity<MascotasResponse> getMascotasByEstado(@PathVariable("estado") String estado) {
//		return ResponseEntity.ok(mascotaService.getMascotaByEstado(estado));
//	}


}
