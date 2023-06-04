package com.portal.comercio.Models;

import java.io.Serializable;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
@Table(name = "ventas_estado", catalog = "", schema = "COMERCIOS")
public class ventasEstado implements Serializable{

    private static final long serialVersionUID = 1L;

    public ventasEstado() {
    }

    @Id
    @Column(name = "id_venta_estado")
    private int id_venta_estado;
    @Column(name = "nombre")
    private String nombre;
    
    public int getId_venta_estado() {
        return id_venta_estado;
    }
    public void setId_venta_estado(int id_venta_estado) {
        this.id_venta_estado = id_venta_estado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
