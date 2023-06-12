package com.portal.comercio.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.portal.comercio.dto.responseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.comercio.Models.VentasModel;

public interface ventasRepository extends JpaRepository<VentasModel, Long>  {

    public Optional<VentasModel> findByIdVenta(Long codigo);
    public List<VentasModel> findByFechaNulaIsNull(); // Recupera todas las ventas no anuladas
    public List<VentasModel> findByFechaNulaIsNotNull(); // Recupera todas las ventas anuladas
    public responseDto anularVenta(Long ventaId, LocalDate fechaNula, String observaciones);
    
}
