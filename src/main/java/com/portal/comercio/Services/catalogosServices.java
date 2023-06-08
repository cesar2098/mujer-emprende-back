package com.portal.comercio.Services;

import com.portal.comercio.Models.Catalogos;
import com.portal.comercio.dto.responseDto;

public interface catalogosServices {
	public responseDto getCatalogosId(Long codigo);
    public responseDto getProductoComercio(Long codigo);
    // public Page<catalogos> getCatalogos(Pageable pageable);
    public responseDto updateCatalogos(Catalogos catalogos, Long codigo);
    public responseDto saveCatalogos(Catalogos catalogos);
}
