package com.portal.comercio.Services;

import com.portal.comercio.Models.catalogos;
import com.portal.comercio.dto.responseDto;

public interface catalogosServices {
	public responseDto getCatalogosId(Long codigo);
    // public Page<catalogos> getCatalogos(Pageable pageable);
    public responseDto updateCatalogos(catalogos catalogos, Long codigo);
    public responseDto saveCatalogos(catalogos catalogos);
    public responseDto updateEstado(catalogos catalogos, Long codigo); 
}
