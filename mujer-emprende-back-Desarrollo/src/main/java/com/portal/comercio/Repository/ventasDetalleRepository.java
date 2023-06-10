package com.portal.comercio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.comercio.Models.VentasDetalleModel;

public interface ventasDetalleRepository extends JpaRepository<VentasDetalleModel, Long> {

    //Optional<VentasDetalle> findByIdVenta(Long ventaId);
    
}
