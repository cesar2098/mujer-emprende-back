package com.portal.comercio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.comercio.Models.comercios;

public interface comerciosRepository extends JpaRepository<comercios, Long> {
    
}
