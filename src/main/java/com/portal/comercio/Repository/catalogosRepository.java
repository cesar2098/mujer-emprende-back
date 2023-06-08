package com.portal.comercio.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.portal.comercio.Models.CatalogosModel;

public interface catalogosRepository extends JpaRepository<CatalogosModel, Long> {
	public Optional<CatalogosModel> findByIdCatalogos(Long codigo);

	@Query(value = "select * from comercios.catalogos c where c.id_comercio = :idComercio", nativeQuery = true)
	public List<CatalogosModel> findCatalogosByIdComercio(@Param("idComercio") Long idComercio);
}
