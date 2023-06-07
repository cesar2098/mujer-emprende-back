package com.portal.comercio.Models;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "ventas", catalog = "", schema = "comercios")
public class Ventas implements Serializable{

    private static final long serialVersionUID = 1L;

    public Ventas() {
    }

    @Id
    @Getter
    @Setter
    @Column(name = "id_venta")
    private Long idVenta;  

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuarios idUsuario;

    @Getter
    @Setter
    @Column(name = "fecha_anula")
    private Date fechaAnula;

    @Getter
    @Setter
    @Column(name = "fecha_pago")
    private Date fechaPago;
    
    @Getter
    @Setter
    @Column(name = "observaciones")
    private String observaciones;

    @Getter
    @Setter
    @Column(name = "created")
    private Date created;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_comercio", referencedColumnName = "id_comercio")
    private Comercios idComercio;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_venta_estado", referencedColumnName = "id_venta_estado")
    private VentasEstado idVentaEstado;

}
