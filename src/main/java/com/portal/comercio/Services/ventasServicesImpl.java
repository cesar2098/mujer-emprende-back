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

    @Autowired
    ventasRepository ventaRepo;

    @Override
    public responseDto getVentasId(Long codigo){
        try {
            Optional<ventas> ventaOptional = ventaRepo.findById(codigo);
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
            rsp.setRespuesta(e.getMessage());
        }
        return rsp;
    }
    // @Override
    // public Page<ventas> getVentas(Pageable pageable){
    //     //List<ventas> ventas = ventaRepo.findAll(pageable);
    //     return null;
    // }

    @Override
    public responseDto updateVentas(ventas ventas, Long codigo){
        try {    
            Optional<ventas> ventaOptional = ventaRepo.findById(codigo);
            if (ventaOptional.isPresent()) {
                ventas venta = ventaOptional.get();
                venta.setFecha_anula(ventas.getFecha_anula());
                venta.setFecha_pago(ventas.getFecha_pago());
                venta.setObservaciones(ventas.getObservaciones());               
                rsp.setCodigo(200);
                rsp.setMensaje("Venta actualizada correctamente");
                ventaRepo.save(venta);
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
    public responseDto saveVentas(ventas ventas){
        try {            
            rsp.setCodigo(200);
            rsp.setMensaje("Venta guardada correctamente");
            rsp.setRespuesta(ventas);
            ventaRepo.save(ventas);
        } catch (Exception e) {
            rsp.setCodigo(500);
            rsp.setMensaje("Error al guardar la venta");
            rsp.setRespuesta(e.getMessage());
        } 
        return rsp;
    }

    @Override
    public responseDto updateEstado(ventas ventas, Long codigo){        
        try {
            Optional<ventas> ventaOptional = ventaRepo.findById(codigo);
            if (ventaOptional.isPresent()) {
                ventas venta = ventaOptional.get();
                venta.setIdVentaEstado(ventas.getIdVentaEstado());               
                rsp.setCodigo(200);
                rsp.setMensaje("Estado de Venta actualizada correctamente");
                ventaRepo.save(venta);
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
}
