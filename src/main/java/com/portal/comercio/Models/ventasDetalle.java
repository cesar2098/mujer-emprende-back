package com.portal.comercio.Models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
@Table(name = "ventas_detalle", catalog = "", schema = "COMERCIOS")
public class ventasDetalle implements Serializable{

    private static final long serialVersionUID = 1L;

    public ventasDetalle() {
    }
    
    @Id
    @Column(name = "id_venta_detalle")
    private int id_venta_detalle;
    @Column(name = "id_venta")
    private ventas id_venta;
    @Column(name = "id_catalogo")
    private catalogos id_catalogo;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "total")
    private Double total;
    @Column(name = "created")
    private Date created;

    public int getId_venta_detalle() {
        return id_venta_detalle;
    }
    public void setId_venta_detalle(int id_venta_detalle) {
        this.id_venta_detalle = id_venta_detalle;
    }
    public ventas getId_venta() {
        return id_venta;
    }
    public void setId_venta(ventas id_venta) {
        this.id_venta = id_venta;
    }
    public catalogos getId_catalogo() {
        return id_catalogo;
    }
    public void setId_catalogo(catalogos id_catalogo) {
        this.id_catalogo = id_catalogo;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
}
