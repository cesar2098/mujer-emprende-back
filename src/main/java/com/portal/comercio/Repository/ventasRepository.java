package com.portal.comercio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.comercio.Models.Ventas;

public interface ventasRepository extends JpaRepository<Ventas, Long>  {

    Optional<Ventas> findByIdVenta(Long codigo);
    
}
