package com.portal.comercio.Services;

import com.portal.comercio.Models.ComerciosModel;
import com.portal.comercio.dto.responseDto;

public interface comercioServices {
	public responseDto getComerciosId(Long codigo);
	public responseDto updateComercios(ComerciosModel comercios, Long codigo);
	public responseDto saveComercios(ComerciosModel comercios);
	public responseDto getAllComercios();
	public responseDto getProductosPorComercio(Long comercioId);
	// public responseDto updateEstado(Comercios comercios, Long codigo);
}
