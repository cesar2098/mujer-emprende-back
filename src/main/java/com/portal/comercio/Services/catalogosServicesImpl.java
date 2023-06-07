package com.portal.comercio.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.comercio.Models.Catalogos;
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
            Optional<Catalogos> catalogosOptional = catalogosRepo.findById(codigo);
            if (catalogosOptional.isPresent()) {
            	Catalogos cata = catalogosOptional.get();
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
    // @Override
    // public Page<ventas> getCatalogos(Pageable pageable){
    //     //List<ventas> ventas = catalogosRepo.findAll(pageable);
    //     return null;
    // }

    @Override
    public responseDto updateCatalogos(Catalogos cata, Long codigo){
        try {    
            Optional<Catalogos> catalogosOptional = catalogosRepo.findById(codigo);
            if (catalogosOptional.isPresent()) {
            	Catalogos venta = catalogosOptional.get();
                /*venta.setFecha_anula(ventas.getFecha_anula());
                venta.setFecha_pago(ventas.getFecha_pago());
                venta.setObservaciones(ventas.getObservaciones()); */              
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
    public responseDto saveCatalogos(Catalogos cata){
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

    @Override
    public responseDto updateEstado(Catalogos cata, Long codigo){        
        try {
            Optional<Catalogos> catalogosOptional = catalogosRepo.findById(codigo);
            if (catalogosOptional.isPresent()) {
            	Catalogos catalogos = catalogosOptional.get();
                //venta.setIdVentaEstado(ventas.getIdVentaEstado());               
                rsp.setCodigo(200);
                rsp.setMensaje("Estado del Catalogo actualizada correctamente");
                catalogosRepo.save(catalogos);
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
}
