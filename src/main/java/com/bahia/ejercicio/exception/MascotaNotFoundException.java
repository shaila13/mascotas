package com.bahia.ejercicio.exception;

public class MascotaNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MascotaNotFoundException(Long id) {
		super("No se ha podido recuperar la mascota con id " + id + ".");
	}

	public MascotaNotFoundException() {
		super("No se ha podido recuperar ninguna mascota.");
	}
}
