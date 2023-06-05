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
    @Autowired
    usuariosServices usuariosSrvc;
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public responseDto saveUsuario(@RequestBody usuarios usuario){
        return usuariosSrvc.saveUsuarios(usuario);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/buscar/{id}")
    public responseDto getUsuarioId(@PathVariable Long id){
        return usuariosSrvc.getUsuariosId(id);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/update/{id}")
    public responseDto updateUsuario(@RequestBody usuarios usuario, @PathVariable Long id){
        return usuariosSrvc.updateUsuarios(usuario, id);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/delete/{id}")
    public responseDto deleteUsuario(@RequestBody usuarios usuario, @PathVariable Long id){
        usuarios userTmp =(usuarios)usuariosSrvc.getUsuariosId(id).getRespuesta();
        return usuariosSrvc.deleteUsuarios(userTmp);
    }
}
