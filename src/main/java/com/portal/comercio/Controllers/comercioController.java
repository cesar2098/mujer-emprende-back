package com.portal.comercio.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portal.comercio.Models.ComerciosModel;
import com.portal.comercio.Services.comercioServices;
import com.portal.comercio.dto.responseDto;

@RestController
@RequestMapping("comercio/comercio")
@CrossOrigin(origins = "http://localhost:4200")
public class comercioController {
	@Autowired
	comercioServices comercio;
	
	@RequestMapping(method = RequestMethod.POST, value ="/save")
	public responseDto saveComercio(@RequestBody ComerciosModel comercios) {
		return comercio.saveComercios(comercios);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/search/{codigo}")
	public responseDto getComerciosId(@PathVariable Long codigo) {
		return comercio.getComerciosId(codigo);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public responseDto getAllComercios() {
		return comercio.getAllComercios();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/update/{codigo}")
	public responseDto updateComercios(@RequestBody ComerciosModel comercios, @PathVariable Long codigo) {
		return comercio.updateComercios(comercios, codigo);
	}
	
	// @RequestMapping(method = RequestMethod.PUT, value = "/updateestado/{codigo}")
	// public responseDto updateEstado(@RequestBody Comercios comercios, @PathVariable Long codigo) {
	// 	return comercio.updateEstado(comercios, codigo);
	// }
}
