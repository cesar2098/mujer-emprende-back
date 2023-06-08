package com.portal.comercio.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.comercio.Models.VentasDetalleModel;
import com.portal.comercio.Repository.ventasDetalleRepository;
import com.portal.comercio.dto.responseDto;

@Service
public class ventasDetalleServicesImpl implements ventasDetalleServices {

    responseDto rsp = new responseDto();

    @Autowired
    ventasDetalleRepository ventaDetalleRepo;

    @Override
    public responseDto getAllVentasDetalle(Long VentaId) {
        try {
            List<VentasDetalleModel> ventaOptional = ventaDetalleRepo.findAll();
            if (!ventaOptional.isEmpty()) {
                //VentasDetalle ventaDetalle = ventaOptional.get(0);
                rsp.setCodigo(200);
                rsp.setMensaje("Venta encontrada");
                rsp.setRespuesta(ventaOptional);
            } else {
                rsp.setCodigo(404);
                rsp.setMensaje("Venta no encontrada");
            }
        } catch (Exception e) {
            rsp.setCodigo(500);
            rsp.setMensaje("Error al buscar la venta");
            rsp.setRespuesta(e.getMessage());
        }
        return rsp;
    }

    @Override
    public responseDto getVentasDetalleId(Long ventaDetalleId) {
        try {
            Optional<VentasDetalleModel> ventaOptional = ventaDetalleRepo.findById(ventaDetalleId);
            if (ventaOptional.isPresent()) {
                VentasDetalleModel ventaDetalle = ventaOptional.get();
                rsp.setCodigo(200);
                rsp.setMensaje("Venta encontrada");
                rsp.setRespuesta(ventaDetalle);
            } else {
                rsp.setCodigo(404);
                rsp.setMensaje("Venta no encontrada");
            }
        } catch (Exception e) {
            rsp.setCodigo(500);
            rsp.setMensaje("Error al buscar la venta");
            rsp.setRespuesta(e.getMessage());
        }
        return rsp;
    }

    @Override
    public responseDto updateVentasDetalle(VentasDetalleModel ventaDetalle, Long codigo) {
        try {    
            Optional<VentasDetalleModel> ventaOptional = ventaDetalleRepo.findById(codigo);
            if (ventaOptional.isPresent()) {
                VentasDetalleModel venta = ventaOptional.get();
                venta.setIdCatalogos(ventaDetalle.getIdCatalogos());
                venta.setCantidad(ventaDetalle.getCantidad());  
                venta.setPrecio(ventaDetalle.getPrecio());
                venta.setTotal(ventaDetalle.getTotal());             
                rsp.setCodigo(200);
                rsp.setMensaje("Venta actualizada correctamente");
                ventaDetalleRepo.save(venta);
            } else {
                rsp.setCodigo(404);
                rsp.setMensaje("Venta no encontrada");
            }
        } catch (Exception e) {
            rsp.setCodigo(500);
            rsp.setMensaje("Error al actualizar la venta");
        }
        return rsp;
    }

    @Override
    public responseDto saveVentasDetalle(VentasDetalleModel ventaDetalle) {
        try {            
            rsp.setCodigo(200);
            rsp.setMensaje("Venta guardada correctamente");
            rsp.setRespuesta(ventaDetalle);
            ventaDetalleRepo.save(ventaDetalle);
        } catch (Exception e) {
            rsp.setCodigo(500);
            rsp.setMensaje("Error al guardar la venta");
            rsp.setRespuesta(e.getMessage());
        } 
        return rsp;
    }
}
