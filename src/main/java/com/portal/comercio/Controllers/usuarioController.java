package com.portal.comercio.Controllers;

import com.portal.comercio.Models.UsuariosModel;
import com.portal.comercio.Services.usuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portal.comercio.dto.responseDto;

@RestController
@RequestMapping("comercio/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class usuarioController {
    @Autowired
    usuariosServices usuariosSrvc;
    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public responseDto saveUsuario(@RequestBody UsuariosModel usuario){
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
    public responseDto updateUsuario(@RequestBody UsuariosModel usuario, @PathVariable Long id){
        return usuariosSrvc.updateUsuarios(usuario, id);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/delete")
    public responseDto deleteUsuario(@RequestBody UsuariosModel usuario){
        UsuariosModel userTmp =(UsuariosModel)usuariosSrvc.getUsuariosId(usuario.getId()).getRespuesta();
        return usuariosSrvc.deleteUsuarios(userTmp);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public responseDto deleteUsuarioId(@PathVariable Long id){
        UsuariosModel userTmp =(UsuariosModel)usuariosSrvc.getUsuariosId(id).getRespuesta();
        return usuariosSrvc.deleteUsuarios(userTmp);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{username}/contrasena")
    public responseDto cambiarContrasena(@PathVariable String username, @RequestBody String nuevaContrasena) {
        if (usuariosSrvc.cambiarContrasena(username, nuevaContrasena).getCodigo() == 200 ) {
            //return ResponseEntity.ok("Contraseña cambiada exitosamente");
            return new responseDto(200,"Contraseña cambiada exitosamente");
        } else {
            return new responseDto(400, "Contraseña no cambiada");
        }
    }
}
