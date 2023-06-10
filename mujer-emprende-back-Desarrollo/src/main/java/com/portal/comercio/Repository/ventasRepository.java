package com.portal.comercio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.comercio.Models.VentasModel;

public interface ventasRepository extends JpaRepository<VentasModel, Long>  {

    public Optional<VentasModel> findByIdVenta(Long codigo);
    
}
