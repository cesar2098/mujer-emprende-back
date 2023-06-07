package com.portal.comercio.Services;

import com.portal.comercio.Models.Usuarios;
import com.portal.comercio.dto.responseDto;

public interface usuariosServices {
    public responseDto getAllUsuarios();
    public responseDto getUsuariosId(Long id);
    public responseDto updateUsuarios(Usuarios user, Long id);
    public responseDto saveUsuarios(Usuarios user);
    public responseDto deleteUsuarios(Usuarios user);
}
