package com.portal.comercio.Controllers;

import java.time.LocalDate;

import com.portal.comercio.dto.responseDtoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portal.comercio.Models.VentasModel;
import com.portal.comercio.Services.ventasServices;
import com.portal.comercio.dto.responseDto;

@RestController
@RequestMapping("comercio/ventas")
@CrossOrigin(origins = "http://localhost:4200")
public class ventasController {

    @Autowired
    ventasServices venta;

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public responseDto saveVentas(@RequestBody VentasModel ventas, @RequestParam(name = "created", defaultValue = "#{T(java.time.LocalDate).now()}", required = true) LocalDate created){
        ventas.setCreated(created);
        return venta.saveVentas(ventas);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search/{codigo}")
    public responseDto getVentasId(@PathVariable Long codigo){
        return venta.getVentasId(codigo);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/update/{codigo}")
    public responseDto updateVentas(@RequestBody VentasModel ventas, @PathVariable Long codigo){
        return venta.updateVentas(ventas, codigo);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/updateestado/{codigo}")
    public responseDto updateEstado(@RequestBody VentasModel ventas, @PathVariable Long codigo){
        return venta.updateEstado(ventas, codigo);
    }
    @RequestMapping("/{ventaId}/anular")
    public responseDto anularVenta(@PathVariable Long ventaId, @RequestBody VentasModel request) {
        if (venta.anularVenta(ventaId, request.getFechaAnula(), request.getObservaciones()).getCodigo() == 200) {
            return new responseDto(200, "Venta anulada exitosamente", responseDtoEnum.INFO);
            //return ResponseEntity.ok("Venta anulada exitosamente");
        } else {
            //return ResponseEntity.notFound().build();
            return new responseDto(400, "Error al anular venta", responseDtoEnum.ERROR);
        }
    }
}
