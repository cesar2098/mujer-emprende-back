package com.portal.comercio.Services;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.portal.comercio.Models.Ventas;
import com.portal.comercio.dto.responseDto;

public interface ventasServices {
    public responseDto getVentasId(Long codigo);
    // public Page<ventas> getVentas(Pageable pageable);
    public responseDto updateVentas(Ventas ventas, Long codigo);
    public responseDto saveVentas(Ventas ventas);
    public responseDto updateEstado(Ventas ventas, Long codigo); 
}
