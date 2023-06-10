package com.portal.comercio.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.comercio.Models.CatalogosModel;
import com.portal.comercio.Repository.catalogosRepository;
import com.portal.comercio.dto.responseDto;

@Service
public class catalogosServicesImpl implements catalogosServices{
	responseDto rsp = new responseDto();

    @Autowired
    catalogosRepository catalogosRepo;

    @Override
    public responseDto getCatalogosId(Long codigo){
        try {
            Optional<CatalogosModel> catalogosOptional = catalogosRepo.findById(codigo);
            if (catalogosOptional.isPresent()) {
            	CatalogosModel cata = catalogosOptional.get();
                rsp.setCodigo(200);
                rsp.setMensaje("Catalogo encontrado");
                rsp.setRespuesta(cata);
            } else {
                rsp.setCodigo(404);
                rsp.setMensaje("Catalogo no encontrado");
            }
        } catch (Exception e) {
            rsp.setCodigo(500);
            rsp.setMensaje("Error al buscar el catalogo");
            rsp.setRespuesta(e.getMessage());
        }
        return rsp;
    }

    @Override
    public responseDto getProductoComercio(Long codigo){
        try {
            List<CatalogosModel> catalogosList = catalogosRepo.findCatalogosByIdComercio(codigo);
            if (!catalogosList.isEmpty()) {
                rsp.setCodigo(200);
                rsp.setMensaje("Catalogo encontrado");
                rsp.setRespuesta(catalogosList);
            } else {
                rsp.setCodigo(404);
                rsp.setMensaje("Catalogo no encontrado");
            }
        } catch (Exception e) {
            rsp.setCodigo(500);
            rsp.setMensaje("Error al buscar el catalogo");
            rsp.setRespuesta(e.getMessage());
        }
        return rsp;
    }

    @Override
    public responseDto updateCatalogos(CatalogosModel cata, Long codigo){
        try {    
            Optional<CatalogosModel> catalogosOptional = catalogosRepo.findById(codigo);
            if (catalogosOptional.isPresent()) {
            	CatalogosModel venta = catalogosOptional.get();
                venta.setNombre(cata.getNombre());
                venta.setDescripcion(cata.getDescripcion());
                venta.setPrecio(cata.getPrecio());
                venta.setImagen(cata.getImagen());        
                venta.setActivo(cata.getActivo());
                rsp.setCodigo(200);
                rsp.setMensaje("Catalogo actualizado correctamente");
                catalogosRepo.save(venta);
            } else {
                rsp.setCodigo(404);
                rsp.setMensaje("Catalogo no encontrado");
            }
        } catch (Exception e) {
            rsp.setCodigo(500);
            rsp.setMensaje("Error al actualizar la catalogo");
        }
        return rsp;
    }

    @Override
    public responseDto saveCatalogos(CatalogosModel cata){
        try {            
            rsp.setCodigo(200);
            rsp.setMensaje("Catalogo guardado correctamente");
            rsp.setRespuesta(cata);
            catalogosRepo.save(cata);
        } catch (Exception e) {
            rsp.setCodigo(500);
            rsp.setMensaje("Error al guardar la catalogo");
            rsp.setRespuesta(e.getMessage());
        } 
        return rsp;
    }
}
