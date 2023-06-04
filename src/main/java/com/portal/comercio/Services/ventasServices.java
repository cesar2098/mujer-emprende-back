package com.portal.comercio.Services;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.portal.comercio.Models.ventas;
import com.portal.comercio.dto.responseDto;

public interface ventasServices {
    public responseDto getVentasId(Long codigo);
    // public Page<ventas> getVentas(Pageable pageable);
    public responseDto updateVentas(ventas ventas, Long codigo);
    public responseDto saveVentas(ventas ventas);
    public responseDto updateEstado(ventas ventas, Long codigo); 
}
