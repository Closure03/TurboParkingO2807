package com.turboparking.entidades;
//Unir esta clase con la base de datos

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="tusuario")
public class Usuario {
    
    @Id
    @Column(name="id_tusuario", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="nom_tusuario", length=45, nullable=false)
    private String nombre;
    
    @Column(name="ced_tusuario", length=40, nullable=false, unique=true)
    private String cedula;
    
    @Column(name="correo_tusuario", length=45, nullable=false, unique=true)
    private String correo;
    
    @Column(name="hora_tusuario", length=45, nullable=false)
    private String horaInicioActividad;
    
    @Column(name="contra_tusuario", length=45, nullable=false)
    private String contraseña;

    public Usuario(String nombre, Integer id, String cedula, String correo, String horaInicioActividad, String contraseña) {
        this.nombre = nombre;
        this.id = id;
        this.cedula = cedula;
        this.correo = correo;
        this.horaInicioActividad = horaInicioActividad;
        this.contraseña = contraseña;
    }
    
    public Usuario(String nombre, String cedula, String correo, String horaInicioActividad, String contraseña) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.horaInicioActividad = horaInicioActividad;
        this.contraseña = contraseña;
    }

    public Usuario() {
    }

    public Usuario(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
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

    public String getHoraInicioActividad() {
        return horaInicioActividad;
    }

    public void setHoraInicioActividad(String horaInicioActividad) {
        this.horaInicioActividad = horaInicioActividad;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", id=" + id + ", cedula=" + cedula + ", correo=" + correo + ", horaInicioActividad=" + horaInicioActividad + ", contrase\u00f1a=" + contraseña + '}';
    }  
}
