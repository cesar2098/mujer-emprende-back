package com.portal.comercio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.comercio.Models.UsuariosModel;

public interface usuariosRepository extends JpaRepository<UsuariosModel, Long> {
    
}
