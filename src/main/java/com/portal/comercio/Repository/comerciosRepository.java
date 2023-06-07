package com.portal.comercio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.comercio.Models.Comercios;
import com.portal.comercio.Models.Ventas;

public interface comerciosRepository extends JpaRepository<Comercios, Long> {
	Optional<Ventas> findByIdComercio(Long codigo);
}
