package com.portal.comercio.Services;

import com.portal.comercio.Models.VentasModel;
import com.portal.comercio.dto.responseDto;

import java.util.Date;

public interface ventasServices {
    public responseDto getVentasId(Long codigo);
    // public Page<ventas> getVentas(Pageable pageable);
    public responseDto updateVentas(VentasModel ventas, Long codigo);
    public responseDto saveVentas(VentasModel ventas);
    public responseDto updateEstado(VentasModel ventas, Long codigo);
    public responseDto anularVenta(Long ventaId, Date fechaNula, String observaciones);
    public responseDto marcarVentaComoPagada(Long ventaId, Date fechaPago);
}
