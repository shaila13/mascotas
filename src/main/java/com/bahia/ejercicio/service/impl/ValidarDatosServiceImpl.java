package com.bahia.ejercicio.service.impl;

import org.springframework.stereotype.Service;

import com.bahia.ejercicio.common.ConstantsError;
import com.bahia.ejercicio.common.Utils;
import com.bahia.ejercicio.dto.MascotaRequest;
import com.bahia.ejercicio.enums.estado.EstadoMascotas;
import com.bahia.ejercicio.exception.ValidationException;
import com.bahia.ejercicio.service.IValidarDatosService;


@Service
public class ValidarDatosServiceImpl implements IValidarDatosService {


	@Override
	public void validarIdMascota(Integer id) throws ValidationException {
		if (id == null) {
			throw new ValidationException(ConstantsError.COD_RESP_ERROR_VALIDACION, "El Id es obligatorio. ");
		}
	}

	@Override
	public void validarEstadoBusquedaMascota(String estado) throws ValidationException {
		if (Utils.nullGuard(() -> estado) == null) {
			throw new ValidationException(ConstantsError.COD_RESP_ERROR_VALIDACION,
					"El estado de busqueda es obligatorio. ");
		}
		
	}

}
