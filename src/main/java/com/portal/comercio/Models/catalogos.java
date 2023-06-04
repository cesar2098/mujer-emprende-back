package com.portal.comercio.Models;


import java.io.Serializable;
import java.sql.Date;


import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
@Table(name = "catalogos", catalog = "", schema = "COMERCIOS")
public class catalogos implements Serializable{

    private static final long serialVersionUID = 1L;

    public catalogos() {
    }   

    @Id
    @Column(name = "id_catalogo")
    private int id_catalogo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "id_comercio")
    private comercios id_comercio;
    @Column(name = "activo")
    private int activo;
    @Column(name = "created")
    private Date created;

    public int getId_catalogo() {
        return id_catalogo;
    }
    public void setId_catalogo(int id_catalogo) {
        this.id_catalogo = id_catalogo;
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
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public comercios getId_comercio() {
        return id_comercio;
    }
    public void setId_comercio(comercios id_comercio) {
        this.id_comercio = id_comercio;
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
