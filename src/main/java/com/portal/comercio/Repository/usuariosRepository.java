package com.portal.comercio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.comercio.Models.Usuarios;

public interface usuariosRepository extends JpaRepository<Usuarios, Long> {
    
}
