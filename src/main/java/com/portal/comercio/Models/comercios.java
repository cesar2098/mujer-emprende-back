package com.portal.comercio.Models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
@Table(name = "comercios", catalog = "", schema = "COMERCIOS")
public class comercios implements Serializable {

    private static final long serialVersionUID = 1L;

    public comercios() {
    }   

    @Id
    @Column(name = "id_comercio")
    private int id_comercio;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "logo")
    private String logo;
    @Column(name = "activo")
    private int activo;
    @Column(name = "created")
    private Date created;

    public int getId_comercio() {
        return id_comercio;
    }
    public void setId_comercio(int id_comercio) {
        this.id_comercio = id_comercio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public int getActivo() {
        return activo;
    }
    public void setActivo(int activo) {
        this.activo = activo;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
}
