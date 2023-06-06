package com.portal.comercio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.comercio.Models.comercios;
import com.portal.comercio.Models.ventas;

public interface comerciosRepository extends JpaRepository<comercios, Long> {
	Optional<ventas> findByIdComercio(Long codigo);
}
