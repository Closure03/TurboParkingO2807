package com.turboparking.entidades;
//Mapeo esta clase con la base de datos

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="tusuarios")
public class Usuario {
    
    @Id
    @Column(name="id_tusuarios")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="nom_tusuarios", length=45, nullable=false)
    private String nombre;
    
    @Column(name="ced_tusuarios", length=40, nullable=false, unique=true)
    private String cedula;
    
    @Column(name="correo_tusuarios", length=45, nullable=false, unique=true)
    private String correo;
    
    @Column(name="contra_tusuarios", length=45, nullable=false)
    private String contrasena;

    public Usuario(String nombre, Integer id, String cedula, String correo, String contrasena) {
        this.nombre = nombre;
        this.id = id;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasena = contrasena;
    }
    
    public Usuario(String nombre, String cedula, String correo, String contrasena) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", id=" + id + ", cedula=" + cedula + ", correo=" + correo + ", contrase\u00f1a=" + contrasena + '}';
    }  
}
