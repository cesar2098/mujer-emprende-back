package com.portal.comercio.Models;


import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "catalogos", catalog = "", schema = "comercios")
public class CatalogosModel implements Serializable{

    private static final long serialVersionUID = 1L;

    public CatalogosModel() {
    }

    @Id
    @Getter
    @Setter
    @Column(name = "id_catalogo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCatalogos;

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
    @Column(name = "precio")
    private Double precio;

    @Getter
    @Setter
    @Column(name = "imagen")
    private String imagen;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_comercio", referencedColumnName = "id_comercio")
    private ComerciosModel idComercio;

    @Getter
    @Setter
    @Column(name = "activo")
    private int activo;

    @Getter
    @Setter
    @Column(name = "created")
    private LocalDate created;

    // @Getter
    // @Setter
    // @ManyToOne
    // @JoinColumn(name = "comercio_id")
    // private ComerciosModel comercio;
}
