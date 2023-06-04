package com.portal.comercio.Models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
@Table(name = "usuarios", catalog = "", schema = "COMERCIOS")
public class usuarios implements Serializable{

    private static final long serialVersionUID = 1L;

    public usuarios() {
    }   
    @Id
    @Column(name = "id_usuario")
    private int id_usuario;
    @Column(name = "correo")
    private String correo;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "contacto")
    private String contacto;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "password")
    private String password;
    @Column(name = "activo")
    private int activo;
    @Column(name = "rol")
    private String rol;
    @Column(name = "created")
    private Date created;
    @Column(name = "id_comercio")
    private comercios id_comercio;

    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getContacto() {
        return contacto;
    }
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getActivo() {
        return activo;
    }
    public void setActivo(int activo) {
        this.activo = activo;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
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
