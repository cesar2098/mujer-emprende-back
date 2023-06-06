package com.portal.comercio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.comercio.Models.catalogos;

public interface catalogosRepository extends JpaRepository<catalogos, Long> {
	Optional<catalogos> findByIdCatalogos(Long codigo);
}
