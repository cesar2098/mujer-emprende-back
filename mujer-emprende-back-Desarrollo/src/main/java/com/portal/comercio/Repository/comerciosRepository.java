package com.portal.comercio.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.comercio.Models.ComerciosModel;
import com.portal.comercio.Models.VentasModel;

public interface comerciosRepository extends JpaRepository<ComerciosModel, Long> {
	public Optional<VentasModel> findByIdComercio(Long codigo);
}
