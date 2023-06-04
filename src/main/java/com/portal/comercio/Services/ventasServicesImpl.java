package com.portal.comercio.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.comercio.Models.ventas;
import com.portal.comercio.Repository.ventasRepository;
import com.portal.comercio.dto.responseDto;

@Service
public class ventasServicesImpl implements ventasServices {

    responseDto rsp = new responseDto();
    ventas venta = new ventas();
    
    @Autowired
    ventasRepository ventaRepo;

    @Override
    public responseDto getVentasId(int codigo){
        try {
            Optional<ventas> ventaOptional = ventaRepo.findById(Long.valueOf(codigo));
            if (ventaOptional.isPresent()) {
                ventas venta = ventaOptional.get();
                rsp.setCodigo(200);
                rsp.setMensaje("Venta encontrada");
                rsp.setRespuesta(venta);
            } else {
                rsp.setCodigo(404);
                rsp.setMensaje("Venta no encontrada");
            }
        } catch (Exception e) {
            rsp.setCodigo(500);
            rsp.setMensaje("Error al buscar la venta");
        }
        return null;
    }
    // @Override
    // public Page<ventas> getVentas(Pageable pageable){
    //     //List<ventas> ventas = ventaRepo.findAll(pageable);
    //     return null;
    // }

    @Override
    public responseDto updateVentas(ventas ventas, int codigo){
        try {          
            venta.setId_venta(codigo);
            venta.setFecha_anula(ventas.getFecha_anula());
            venta.setId_venta_estado(1);
            venta.setFecha_pago(ventas.getFecha_pago());
            venta.setObservaciones(ventas.getObservaciones());
            ventaRepo.save(venta);
            rsp.setCodigo(200);
            rsp.setMensaje("Venta actualizada correctamente");
        } catch (Exception e) {
            rsp.setCodigo(500);
            rsp.setMensaje("Error al actualizar la venta");
        }
        return rsp;
    }

    @Override
    public responseDto saveVentas(ventas ventas){
        try {
            ventaRepo.save(ventas);
            rsp.setCodigo(200);
            rsp.setMensaje("Venta guardada correctamente");
        } catch (Exception e) {
            rsp.setCodigo(500);
            rsp.setMensaje("Error al guardar la venta");
        } 
        return null;
    }

    @Override
    public responseDto updateEstado(ventas ventas, int codigo){        
        try {
            venta.setId_venta(codigo);
            venta.setId_venta_estado(ventas.getId_venta_estado());
            ventaRepo.save(venta);
            rsp.setCodigo(200);
            rsp.setMensaje("Estado de Venta actualizada correctamente");
        } catch (Exception e) {
            rsp.setCodigo(500);
            rsp.setMensaje("Error al actualizar la venta");
        }
        return rsp;
    } 
}
