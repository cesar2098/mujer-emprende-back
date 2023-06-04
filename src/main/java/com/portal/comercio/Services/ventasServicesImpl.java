package com.portal.comercio.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.portal.comercio.Models.ventas;
import com.portal.comercio.Repository.ventasRepository;
import com.portal.comercio.dto.responseDto;

@Service
public class ventasServicesImpl implements ventasServices {
    
    // @Autowired
    // ventasRepository ventaRepo;

    @Override
    public responseDto getVentasId(int codigo){
        return null;
    }
    // @Override
    // public Page<ventas> getVentas(Pageable pageable){
    //     //List<ventas> ventas = ventaRepo.findAll(pageable);
    //     return null;
    // }
    @Override
    public responseDto updateVentas(ventas ventas, int codigo){
        responseDto rsp = new responseDto();
        // try {
        //     ventas venta = new ventas();
        //     venta.setId_venta(codigo);
        //     venta.setFecha_anula(ventas.getFecha_anula());
        //     venta.setFecha_pago(ventas.getFecha_pago());
        //     venta.setObservaciones(ventas.getObservaciones());
        //     ventaRepo.save(venta);
        //     rsp.setCodigo(200);
        //     rsp.setMensaje("Venta actualizada correctamente");
        // } catch (Exception e) {
        //     rsp.setCodigo(500);
        //     rsp.setMensaje("Error al actualizar la venta");
        // }
        return rsp;
    }
    @Override
    public responseDto saveVentas(ventas ventas){
        return null;
    }
    @Override
    public responseDto updateEstado(ventas ventas, int codigo){
        responseDto rsp = new responseDto();
        // try {
        //     ventas venta = new ventas();
        //     venta.setId_venta(codigo);
        //     venta.setEstado(ventas.getEstado());
        //     ventaRepo.save(venta);
        //     rsp.setCodigo(200);
        //     rsp.setMensaje("Estado de Venta actualizada correctamente");
        // } catch (Exception e) {
        //     rsp.setCodigo(500);
        //     rsp.setMensaje("Error al actualizar la venta");
        // }
        return rsp;
    } 
}
