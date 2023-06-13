package com.portal.comercio.Models;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comercios", catalog = "", schema = "comercios")
public class ComerciosModel implements Serializable {

    private static final long serialVersionUID = 1L;

    public ComerciosModel() {
    }

    @Id
    @Getter
    @Setter
    @Column(name = "id_comercio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private LocalDate created;

    @Getter
    @Setter
    @OneToMany(mappedBy = "idComercio")
    private List<CatalogosModel> productos;
    // @Getter
    // @Setter
    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name = "id_comercio_estado", referencedColumnName = "id_comercio_estado")
    // private ComerciosEstado idComercioEstado;
}
