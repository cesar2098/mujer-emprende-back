package com.portal.comercio.Services;

import java.util.List;
import java.util.Optional;

import com.portal.comercio.Models.CatalogosModel;
import com.portal.comercio.dto.responseDtoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.comercio.Models.ComerciosModel;
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
			Optional<ComerciosModel> comercioOptional = comercioRepo.findById(codigo);
			if(comercioOptional.isPresent()) {
				ComerciosModel comercio = comercioOptional.get();
				rsp.setCodigo(200);
				rsp.setMensaje("Comercio encontrado");
				rsp.setRespuesta(comercio);
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
	public responseDto getAllComercios() {
		try {
			List<ComerciosModel> comercioList = comercioRepo.findAll();
			if(!comercioList.isEmpty()) {
				rsp.setCodigo(200);
				rsp.setMensaje("Comercio encontrado");
				rsp.setRespuesta(comercioList);
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
	public responseDto updateComercios(ComerciosModel comercios, Long codigo) {
		try {
			Optional<ComerciosModel> comercioOptional = comercioRepo.findById(codigo);
            if (comercioOptional.isPresent()) {
                ComerciosModel comercio = comercioOptional.get();
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
	public responseDto saveComercios(ComerciosModel comercios) {
		try {
			rsp.setCodigo(200);
            rsp.setMensaje("Comercio guardado correctamente");
			rsp.setRespuesta(null);
            comercioRepo.save(null);
		} catch (Exception e) {
			rsp.setCodigo(500);
            rsp.setMensaje("Error al guardar el comercio");
            rsp.setRespuesta(e.getMessage());
		}
		return rsp;
	}


	public responseDto getProductosPorComercio(Long comercioId) {
		Optional<ComerciosModel> comercioOptional = comercioRepo.findById(comercioId);

		if (comercioOptional.isPresent()) {
			ComerciosModel comercio = comercioOptional.get();
			rsp.setResponse(200,"Catalogo encontrado.", comercio.getProductos(), responseDtoEnum.INFO);
			//return comercio.getProductos();
		}
		return rsp;
		//return Collections.emptyList();
	}

	// @Override
	// public responseDto updateEstado(Comercios comercios, Long codigo) {
	// 	try {
	// 		Optional<Comercios> comercioOptional = comercioRepo.findById(codigo);
    //         if (comercioOptional.isPresent()) {
    //             Comercios comercio = comercioOptional.get();
    //             comercio.setIdComercioEstado(comercios.getIdComercioEstado());               
    //             rsp.setCodigo(200);
    //             rsp.setMensaje("Estado de Comercio actualizado correctamente");
    //             comercioRepo.save(comercio);
    //         } else {
    //             rsp.setCodigo(404);
    //             rsp.setMensaje("Comercio no encontrado");
    //         }
	// 	} catch (Exception e) {
	// 		rsp.setCodigo(500);
    //         rsp.setMensaje("Error al actualizar el comercio");
	// 	}
	// 	return rsp;
	// }
	
	
}
