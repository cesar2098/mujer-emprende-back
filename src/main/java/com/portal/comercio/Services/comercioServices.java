package com.portal.comercio.Services;

import com.portal.comercio.Models.comercios;
import com.portal.comercio.dto.responseDto;

public interface comercioServices {
	public responseDto getComerciosId(Long codigo);
	public responseDto updateComercios(comercios comercios, Long codigo);
	public responseDto saveComercios(comercios comercios);
	public responseDto updateEstado(comercios comercios, Long codigo);
}
