package com.portal.comercio.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portal.comercio.Models.VentasDetalleModel;
import com.portal.comercio.Services.ventasDetalleServices;
import com.portal.comercio.dto.responseDto;

@RestController
@RequestMapping("comercio/ventasdetalle")
@CrossOrigin(origins = "http://localhost:4200")
public class ventasDetalleController {
    
    @Autowired
    ventasDetalleServices ventaDetalle;

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public responseDto saveVentasDetalle(@RequestBody VentasDetalleModel ventas){
        return ventaDetalle.saveVentasDetalle(ventas);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search/{codigo}")
    public responseDto getVentasId(@PathVariable Long codigo){
        return ventaDetalle.getVentasDetalleId(codigo);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/update/{codigo}")
    public responseDto updateVentas(@RequestBody VentasDetalleModel ventas, @PathVariable Long codigo){
        return ventaDetalle.updateVentasDetalle(ventas, codigo);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchAll/{codigo}")
    public responseDto getAllVentas(@PathVariable Long codigo){
        return ventaDetalle.getAllVentasDetalle(codigo);
    }

}
