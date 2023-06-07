package com.portal.comercio.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portal.comercio.Models.Comercios;
import com.portal.comercio.Services.comercioServices;
import com.portal.comercio.dto.responseDto;

@RestController
@RequestMapping("comercio/comercio")
public class comercioController {
	@Autowired
	comercioServices comercio;
	
	@RequestMapping(method = RequestMethod.POST, value ="/save")
	public responseDto saveComercio(@RequestBody Comercios comercios) {
		return comercio.saveComercios(comercios);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/search/{codigo}")
	public responseDto getComerciosId(@PathVariable Long codigo) {
		return comercio.getComerciosId(codigo);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update/{codigo}")
	public responseDto updateComercios(@RequestBody Comercios comercios, @PathVariable Long codigo) {
		return comercio.updateComercios(comercios, codigo);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateestado/{codigo}")
	public responseDto updateEstado(@RequestBody Comercios comercios, @PathVariable Long codigo) {
		return comercio.updateEstado(comercios, codigo);
	}
}
