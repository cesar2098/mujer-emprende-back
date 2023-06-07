package com.portal.comercio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.comercio.Models.Catalogos;

public interface catalogosRepository extends JpaRepository<Catalogos, Long> {
	Optional<Catalogos> findByIdCatalogos(Long codigo);
}
