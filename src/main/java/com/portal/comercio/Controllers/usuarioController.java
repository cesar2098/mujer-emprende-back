package com.portal.comercio.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class usuarioController {

    @RequestMapping("comercio/prueba")
    @GetMapping
    public String prueba(){
        return "Hola mundo";
    }
    
}
