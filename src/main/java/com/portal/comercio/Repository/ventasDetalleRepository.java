package com.portal.comercio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.comercio.Models.VentasDetalle;

public interface ventasDetalleRepository extends JpaRepository<VentasDetalle, Long> {
    
}
