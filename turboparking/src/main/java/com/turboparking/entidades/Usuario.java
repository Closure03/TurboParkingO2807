package com.turboparking.entidades;
//Unir esta clase con la base de datos

public class Usuario {
    private String nombre;
    private Integer id;
    private Integer cedula;
    private String correo;
    private String horaInicioActividad;
    private String contraseña;

    public Usuario(String nombre, Integer id, Integer cedula, String correo, String horaInicioActividad, String contraseña) {
        this.nombre = nombre;
        this.id = id;
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

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
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
