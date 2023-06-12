package com.portal.comercio.Services;

import java.time.LocalDate;
import java.util.Optional;

import com.portal.comercio.dto.responseDtoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.comercio.Models.VentasModel;
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
            Optional<VentasModel> ventaOptional = ventaRepo.findById(codigo);
            if (ventaOptional.isPresent()) {
                VentasModel venta = ventaOptional.get();
               // rsp.setCodigo(200);
               // rsp.setMensaje("[INFO]: Venta encontrada");
               // rsp.setRespuesta(venta);
                rsp.setResponse(200, "Venta encontrada", venta, responseDtoEnum.INFO);
            } else {
               // rsp.setCodigo(404);
               // rsp.setMensaje("[ERROR]: Venta no encontrada");
                rsp.setResponse(404, "Venta no encontrada", responseDtoEnum.ERROR);
            }
        } catch (Exception e) {
            /*
            rsp.setCodigo(500);
            rsp.setMensaje("[ERROR]: Error al buscar la venta");
            rsp.setRespuesta(e.getMessage());*/
            rsp.setResponse(500,"Error al buscar la venta", e.getMessage(),responseDtoEnum.ERROR);
        }
        return rsp;
    }
    // @Override
    // public Page<ventas> getVentas(Pageable pageable){
    //     //List<ventas> ventas = ventaRepo.findAll(pageable);
    //     return null;
    // }

    @Override
    public responseDto updateVentas(VentasModel ventas, Long codigo){
        try {    
            Optional<VentasModel> ventaOptional = ventaRepo.findById(codigo);
            if (ventaOptional.isPresent()) {
                VentasModel venta = ventaOptional.get();
                venta.setFechaAnula(ventas.getFechaAnula());
                venta.setFechaPago(ventas.getFechaPago());
                venta.setObservaciones(ventas.getObservaciones());               
               /* rsp.setCodigo(200);
                rsp.setMensaje("[INFO]: Venta actualizada correctamente");*/
                ventaRepo.save(venta);
                rsp.setResponse(200, "Venta actualizada correctamente", venta, responseDtoEnum.INFO);
            } else {
                //rsp.setCodigo(404);
                //rsp.setMensaje("[ERROR]: Venta no encontrada");
                rsp.setResponse(404,"Venta no enccontrada", responseDtoEnum.ERROR);
            }
        } catch (Exception e) {
            /*
            rsp.setCodigo(500);
            rsp.setMensaje("[ERROR]: Error al actualizar la venta");*/
            rsp.setResponse(500, "Error al actualizar la venta", e.getMessage(), responseDtoEnum.ERROR);
        }
        return rsp;
    }

    @Override
    public responseDto saveVentas(VentasModel ventas){
        try {
            /*
            rsp.setCodigo(200);
            rsp.setMensaje("[INFO]: Venta guardada correctamente");
            rsp.setRespuesta(ventas);*/
            ventaRepo.save(ventas);
            rsp.setResponse(200,"Venta guardada correctamente", ventas, responseDtoEnum.INFO);
        } catch (Exception e) {
            /*
            rsp.setCodigo(500);
            rsp.setMensaje("[ERROR]: Error al guardar la venta");
            rsp.setRespuesta(e.getMessage());*/
            rsp.setResponse(500,"Error al guarda la venta", e.getMessage(), responseDtoEnum.ERROR);
        } 
        return rsp;
    }

    @Override
    public responseDto updateEstado(VentasModel ventas, Long codigo){        
        try {
            Optional<VentasModel> ventaOptional = ventaRepo.findById(codigo);
            if (ventaOptional.isPresent()) {
                VentasModel venta = ventaOptional.get();
                venta.setIdVentaEstado(ventas.getIdVentaEstado());               
                /*rsp.setCodigo(200);
                rsp.setMensaje("[INFO]: Estado de Venta actualizada correctamente");*/
                ventaRepo.save(venta);
                rsp.setResponse(200,  "Estado de Venta actualizada correctamente",venta, responseDtoEnum.INFO);
            } else {
                /*
                rsp.setCodigo(404);
                rsp.setMensaje("Venta no encontrada",responseDtoEnum.ERROR);*/
                rsp.setResponse(404,"Venta no encontrada", responseDtoEnum.ERROR);
            }
        } catch (Exception e) {
            /*
            rsp.setCodigo(500);
            rsp.setMensaje("Error al actualizar la venta");*/
            rsp.setResponse(500,"Error al actualizar la venta", responseDtoEnum.ERROR);
        }
        return rsp;
    }


    //No se envio el metodo completo
    @Override
    public responseDto anularVenta(Long ventaId, LocalDate fechaNula, String observaciones) {
        return null;
    }

    @Override
    public responseDto marcarVentaComoPagada(Long ventaId, LocalDate fechaPago) {
        Optional<VentasModel> ventaOptional = ventaRepo.findById(ventaId);

        if (ventaOptional.isPresent()) {
            VentasModel venta = ventaOptional.get();
            venta.setFechaPago(fechaPago);
            ventaRepo.save(venta);
            return new responseDto(200, "Venta ha sido marcada como pagada",venta, responseDtoEnum.INFO);
        }
        return new responseDto(400, "No se ha podido marcar venta como pagada", responseDtoEnum.ERROR);
        //return false;
    }
}
