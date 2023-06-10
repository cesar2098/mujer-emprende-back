package com.portal.comercio.Models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comercio_estado", catalog = "", schema = "comercios")
public class ComerciosEstadoModel implements Serializable {
	private static final long serialVersionUID = 1L;
	public ComerciosEstadoModel() {}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id_comercio_estado")
    private Long idComercioEstado;
	
	@Getter
    @Setter
    @Column(name = "nombre")
    private String nombre;
}
