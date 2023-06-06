package com.portal.comercio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.comercio.Models.usuarios;

public interface usuariosRepository extends JpaRepository<usuarios, Long> {
    
}
