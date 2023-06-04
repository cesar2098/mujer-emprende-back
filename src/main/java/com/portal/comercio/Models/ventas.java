package com.portal.comercio.Models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
@Table(name = "ventas", catalog = "", schema = "COMERCIOS")
public class ventas implements Serializable{

    private static final long serialVersionUID = 1L;

    public ventas() {
    }

    @Id
    @Column(name = "id_venta")
    private int id_venta;
    @Column(name = "id_usuario")
    private usuarios id_usuario;
    @Column(name = "fecha_anula")
    private Date fecha_anula;
    @Column(name = "fecha_pago")
    private Date fecha_pago;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "created")
    private Date created;
    @Column(name = "id_comercio")
    private comercios id_comercio;
    @Getter
    @Setter
    @Column(name = "id_venta_estado")
    private int id_venta_estado;

    public int getId_venta() {
        return id_venta;
    }
    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }
    public usuarios getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(usuarios id_usuario) {
        this.id_usuario = id_usuario;
    }
    public Date getFecha_anula() {
        return fecha_anula;
    }
    public void setFecha_anula(Date fecha_anula) {
        this.fecha_anula = fecha_anula;
    }
    public Date getFecha_pago() {
        return fecha_pago;
    }
    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public comercios getId_comercio() {
        return id_comercio;
    }
    public void setId_comercio(comercios id_comercio) {
        this.id_comercio = id_comercio;
    }   
}
