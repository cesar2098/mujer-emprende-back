package com.portal.comercio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.comercio.Models.VentasDetalle;

public interface ventasDetalleRepository extends JpaRepository<VentasDetalle, Long> {

    //Optional<VentasDetalle> findByIdVenta(Long ventaId);
    
}
