package com.portal.comercio.Services;

import com.portal.comercio.Models.Comercios;
import com.portal.comercio.dto.responseDto;

public interface comercioServices {
	public responseDto getComerciosId(Long codigo);
	public responseDto updateComercios(Comercios comercios, Long codigo);
	public responseDto saveComercios(Comercios comercios);
	public responseDto updateEstado(Comercios comercios, Long codigo);
}
