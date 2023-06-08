package com.portal.comercio.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portal.comercio.Models.*;
import com.portal.comercio.Services.*;
import com.portal.comercio.dto.responseDto;


@RestController
@RequestMapping("comercio/catalogos")
public class catalogosController {
	@Autowired
	catalogosServices catalogosservice;
	
	@RequestMapping(method = RequestMethod.POST, value = "/save")
    public responseDto saveCatalogos(@RequestBody Catalogos cata){
        return catalogosservice.saveCatalogos(cata);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search/{codigo}")
    public responseDto getCatalogosId(@PathVariable Long codigo){
        return catalogosservice.getCatalogosId(codigo);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/productcomercio/{codigo}")
    public responseDto getProductoComercio(@PathVariable Long codigo){
        return catalogosservice.getProductoComercio(codigo);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/update/{codigo}")
    public responseDto updateCatalogos(@RequestBody Catalogos cata, @PathVariable Long codigo){
        return catalogosservice.updateCatalogos(cata, codigo);
    }
}