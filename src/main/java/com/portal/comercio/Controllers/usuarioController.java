package com.portal.comercio.Controllers;

import com.portal.comercio.Models.Usuarios;
import com.portal.comercio.Models.Ventas;
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
    public responseDto saveUsuario(@RequestBody Usuarios usuario){
        return usuariosSrvc.saveUsuarios(usuario);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/search/{id}")
    public responseDto getUsuarioId(@PathVariable Long id){
        return usuariosSrvc.getUsuariosId(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public responseDto getAllUsuarios(){
        return usuariosSrvc.getAllUsuarios();
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/update/{id}")
    public responseDto updateUsuario(@RequestBody Usuarios usuario, @PathVariable Long id){
        return usuariosSrvc.updateUsuarios(usuario, id);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/delete")
    public responseDto deleteUsuario(@RequestBody Usuarios usuario){
        Usuarios userTmp =(Usuarios)usuariosSrvc.getUsuariosId(usuario.getIdUsuario()).getRespuesta();
        return usuariosSrvc.deleteUsuarios(userTmp);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public responseDto deleteUsuarioId(@PathVariable Long id){
        Usuarios userTmp =(Usuarios)usuariosSrvc.getUsuariosId(id).getRespuesta();
        return usuariosSrvc.deleteUsuarios(userTmp);
    }
}
