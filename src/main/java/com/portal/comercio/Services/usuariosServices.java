package com.portal.comercio.Services;

import com.portal.comercio.Models.usuarios;
import com.portal.comercio.dto.responseDto;

public interface usuariosServices {
    public responseDto getAllUsuarios();
    public responseDto getUsuariosId(Long id);
    public responseDto updateUsuarios(usuarios user, Long id);
    public responseDto saveUsuarios(usuarios user);
    public responseDto deleteUsuarios(usuarios user);
}
