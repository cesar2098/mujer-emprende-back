package com.portal.comercio.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portal.comercio.dto.responseDto;

@RestController
public class usuarioController {

    @RequestMapping(method = RequestMethod.GET,  value = "comercio/prueba")
    public String prueba(){
        return "Hola mundo";
    }
    
}
