package com.portal.comercio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.comercio.Models.ventas;

public interface ventasRepository extends JpaRepository<ventas, Long>  {
    
}
