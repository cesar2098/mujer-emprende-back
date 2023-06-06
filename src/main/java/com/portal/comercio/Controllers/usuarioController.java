package com.portal.comercio.Controllers;

import com.portal.comercio.Models.usuarios;
import com.portal.comercio.Models.ventas;
import com.portal.comercio.Services.usuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portal.comercio.dto.responseDto;

@RestController
@RequestMapping("comercio/usuarios")
public class usuarioController {


    @RequestMapping(method = RequestMethod.GET,  value = "comercio/prueba")
    public String prueba(){
        return "Hola mundo";
    }    
}