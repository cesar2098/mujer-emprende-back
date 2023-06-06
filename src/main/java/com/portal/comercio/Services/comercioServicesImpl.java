package com.portal.comercio.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.comercio.Models.comercios;
import com.portal.comercio.Repository.comerciosRepository;
import com.portal.comercio.dto.responseDto;

@Service
public class comercioServicesImpl implements comercioServices{
	responseDto rsp = new responseDto();
	
	@Autowired
	comerciosRepository comercioRepo;

	@Override
	public responseDto getComerciosId(Long codigo) {
		try {
			Optional<comercios> comercioOptional = comercioRepo.findById(codigo);
			if(comercioOptional.isPresent()) {
				comercios comercio = comercioOptional.get();
				rsp.setCodigo(200);
				rsp.setMensaje("Comercio encontrado");
			} else {
				rsp.setCodigo(404);
				rsp.setMensaje("Comercio no encontrado");
			}
		} catch (Exception e) {
			rsp.setCodigo(500);
			rsp.setMensaje("Error al buscar la comercio");
			rsp.setRespuesta(e.getMessage());
		}
		return rsp;
	}

	@Override
	public responseDto updateComercios(comercios comercios, Long codigo) {
		try {
			Optional<comercios> comercioOptional = comercioRepo.findById(codigo);
            if (comercioOptional.isPresent()) {
                comercios comercio = comercioOptional.get();
                comercio.setNombre(comercios.getNombre());
                comercio.setDescripcion(comercios.getDescripcion());
                comercio.setLogo(comercios.getLogo());
                comercio.setActivo(comercios.getActivo());
                
                rsp.setCodigo(200);
                rsp.setMensaje("Comercio actualizado correctamente");
                comercioRepo.save(comercio);
            } else {
                rsp.setCodigo(404);
                rsp.setMensaje("Comercio no encontrada");
            }
		} catch (Exception e) {
			rsp.setCodigo(500);
            rsp.setMensaje("Error al actualizar el comercio");
		}
		return rsp;
	}

	@Override
	public responseDto saveComercios(comercios comercios) {
		try {
			rsp.setCodigo(200);
            rsp.setMensaje("Comercio guardado correctamente");
            rsp.setRespuesta(comercios);
            comercioRepo.save(comercios);
		} catch (Exception e) {
			rsp.setCodigo(500);
            rsp.setMensaje("Error al guardar el comercio");
            rsp.setRespuesta(e.getMessage());
		}
		return rsp;
	}

	@Override
	public responseDto updateEstado(comercios comercios, Long codigo) {
		try {
			Optional<comercios> comercioOptional = comercioRepo.findById(codigo);
            if (comercioOptional.isPresent()) {
                comercios comercio = comercioOptional.get();
                comercio.setIdComerciosEstado(comercios.getIdComerciosEstado());               
                rsp.setCodigo(200);
                rsp.setMensaje("Estado de Comercio actualizado correctamente");
                comercioRepo.save(comercio);
            } else {
                rsp.setCodigo(404);
                rsp.setMensaje("Comercio no encontrado");
            }
		} catch (Exception e) {
			rsp.setCodigo(500);
            rsp.setMensaje("Error al actualizar el comercio");
		}
		return rsp;
	}
	
	
}
