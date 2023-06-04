package com.portal.comercio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.comercio.Models.ventas;

public interface ventasRepository extends JpaRepository<ventas, Long>  {

    Optional<ventas> findByIdVenta(Long codigo);
    
}
