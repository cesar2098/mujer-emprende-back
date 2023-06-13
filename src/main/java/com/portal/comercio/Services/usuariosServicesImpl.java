package com.portal.comercio.Services;

import com.portal.comercio.Models.UsuariosModel;
import com.portal.comercio.Repository.usuariosRepository;
import com.portal.comercio.dto.responseDto;
import com.portal.comercio.dto.responseDtoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usuariosServicesImpl implements usuariosServices {
    responseDto rsp = new responseDto();
    @Autowired
    usuariosRepository userRepo;
    @Override
    public responseDto getAllUsuarios() {
        try{
            List<UsuariosModel> usuariosList = userRepo.findAll();
            rsp.setCodigo(200);
            rsp.setMensaje("[INFO]: Usuarios encontrados.");
            rsp.setRespuesta(usuariosList);
        }catch (Exception exp){
            rsp.setCodigo(500);
            rsp.setMensaje("[Error]: No se ha podido devolver la lista usuarios");
            rsp.setRespuesta(exp.getMessage());
        }
        return rsp;
    }

    @Override
    public responseDto getUsuariosId(Long id) {
        try{
            Optional<UsuariosModel> usuarioOptional = userRepo.findById(id);
            if(usuarioOptional.isPresent()){
                UsuariosModel usuario = usuarioOptional.get();
                rsp.setCodigo(200);
                rsp.setMensaje("[INFO]: Usuario encontrado");
                rsp.setRespuesta(usuario);
            }else{
                rsp.setCodigo(404);
                rsp.setMensaje(String.format("[INFO]: El usuario no ha sido encontrado.\n el \'id\' utilizado es %d", id));
            }
        }catch(Exception exp){
            rsp.setCodigo(500);
            rsp.setMensaje("[Error]: al buscar el usuario.");
            rsp.setRespuesta(exp.getMessage());
        }
        return rsp;
    }

    @Override
    public responseDto updateUsuarios(UsuariosModel user, Long id) {
        try{
            Optional<UsuariosModel> usuarioOptional = userRepo.findById(id);
            if (usuarioOptional.isPresent()) {
                UsuariosModel usuario = usuarioOptional.get();
                usuario.setActivo(user.getActivo());
                usuario.setApellidos(user.getApellidos());
                usuario.setContacto(user.getContacto());
                usuario.setCreated(user.getCreated());
                usuario.setUsername(user.getUsername());
                usuario.setDireccion(user.getDireccion());
                usuario.setNombres(user.getNombres());
                usuario.setIdComercio(user.getIdComercio());
                usuario.setPassword(user.getPassword());
                usuario.setRol(user.getRol());
                rsp.setCodigo(200);
                rsp.setMensaje("[INFO]: Usuario actualizado correctamente.");
                userRepo.save(usuario);
            } else {
                rsp.setCodigo(404);
                rsp.setMensaje("[Error]: Usuario no ha sido encontrado");
            }
        }catch (Exception exp){
            rsp.setCodigo(500);
            rsp.setMensaje("[Error]: No se a podido actualizar el usuario");
        }
        return rsp;
    }

    @Override
    public responseDto saveUsuarios(UsuariosModel user) {
        try {
            rsp.setCodigo(200);
            rsp.setMensaje("[INFO]: Usuario guardado correctamente");
            rsp.setRespuesta(user);
            userRepo.save(user);
        } catch (Exception e) {
            rsp.setCodigo(500);
            rsp.setMensaje("[ERROR]: Error al guardar el usuario");
            rsp.setRespuesta(e.getMessage());
        }
        return rsp;
    }

    @Override
    public responseDto deleteUsuarios(UsuariosModel user) {
        try {
            UsuariosModel uTmp = new UsuariosModel();
            rsp.setCodigo(200);
            rsp.setMensaje("[INFO]: El usuario ha sido eliminado con exito.");
            rsp.setRespuesta(uTmp);
            userRepo.delete(user);
        } catch (Exception e) {
            rsp.setCodigo(500);
            rsp.setMensaje("[ERROR]: Error al eliminar el usuario");
            rsp.setRespuesta(e.getMessage());
        }
        return rsp;
    }

    @Override
    public responseDto findByUsername(String username) {
        UsuariosModel userM = userRepo.findAll()
                .stream()
                .filter(e -> e.getUsername().equals(username))
                .findFirst()
                .orElse(null);
        userM.setPassword(new BCryptPasswordEncoder().encode(userM.getPassword()));
        return new responseDto(200,"Usuario Encontrado", userM, responseDtoEnum.INFO);
    }

    public responseDto cambiarContrasena(String username, String nuevaContrasena) {
        UsuariosModel user = (UsuariosModel) userRepo.findByUsername(username).getRespuesta();

        if (user != null) {
            user.setPassword(nuevaContrasena);
            userRepo.save(user);
            rsp.setResponse(200,"Contraseña cambiada",user, responseDtoEnum.INFO);
        }else{
            rsp.setResponse(400,"Contrseña no cambiada",responseDtoEnum.ERROR);
        }
        return rsp;
        //return false;
    }
}
