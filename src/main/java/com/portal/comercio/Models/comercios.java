package com.portal.comercio.Models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Column;

@Entity
@Table(name = "comercios", catalog = "", schema = "comercios")
public class Comercios implements Serializable {

    private static final long serialVersionUID = 1L;

    public Comercios() {
    }   

    @Id
    @Getter
    @Setter
    @Column(name = "id_comercio")
    private int idComercio;

    @Getter
    @Setter
    @Column(name = "nombre")
    private String nombre;

    @Getter
    @Setter
    @Column(name = "descripcion")
    private String descripcion;

    @Getter
    @Setter
    @Column(name = "logo")
    private String logo;

    @Getter
    @Setter
    @Column(name = "activo")
    private int activo;

    @Getter
    @Setter
    @Column(name = "created")
    private Date created;
    
    // @Getter
    // @Setter
    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name = "id_comercio_estado", referencedColumnName = "id_comercio_estado")
    // private ComerciosEstado idComercioEstado;
}
