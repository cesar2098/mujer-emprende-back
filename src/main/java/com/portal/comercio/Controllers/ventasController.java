package com.portal.comercio.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portal.comercio.Models.ventas;
import com.portal.comercio.Services.ventasServices;
import com.portal.comercio.dto.responseDto;

@RestController
@RequestMapping("comercio/ventas")
public class ventasController {

    @Autowired
    ventasServices venta;
    
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public responseDto saveVentas(@RequestBody ventas ventas){
        return venta.saveVentas(ventas);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/buscar/{codigo}")
    public responseDto getVentasId(@PathVariable Long codigo){
        return venta.getVentasId(codigo);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/update/{codigo}")
    public responseDto updateVentas(@RequestBody ventas ventas, @PathVariable Long codigo){
        return venta.updateVentas(ventas, codigo);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/updateestado/{codigo}")
    public responseDto updateEstado(@RequestBody ventas ventas, @PathVariable Long codigo){
        return venta.updateEstado(ventas, codigo);
    }
}
