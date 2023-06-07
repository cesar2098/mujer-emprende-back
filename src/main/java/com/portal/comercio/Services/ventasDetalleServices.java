package com.portal.comercio.Services;

import com.portal.comercio.Models.VentasDetalle;
import com.portal.comercio.dto.responseDto;

public interface ventasDetalleServices {
    public responseDto getAllVentasDetalle(Long idVenta);
    public responseDto getVentasDetalleId(Long id);
    public responseDto updateVentasDetalle(VentasDetalle venta, Long id);
    public responseDto saveVentasDetalle(VentasDetalle venta);
}
