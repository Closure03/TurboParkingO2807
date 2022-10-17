/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turboparking.entidades;

import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "tparqueos")
public class Parqueo {

    @Id
    @Column(name="id_tparqueos", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="lugar_tparqueos", nullable=false, length=45)
    private String lugarParqueo;
    
    @Column(name="num_puesto_tparqueos", nullable=false)
    private int numeroParqueo;
    
    @Column(name="hora_inicio_tparqueos", nullable=false)
    @DateTimeFormat(pattern="HH:mm")
    private LocalTime horaInicio;
    
    @Column(name="hora_salida_tparqueos", nullable=false)
    @DateTimeFormat(pattern="HH:mm")
    private LocalTime horaSalida;
    
    @Column(name="habilitado_tparqueos",columnDefinition="TINYINT" ,nullable=false)
    private Boolean habilitado;
    
    @ManyToOne
    @JoinColumn(name="id_tvehiculos", nullable=false)
    private Vehiculo idTablaVehiculo;

    public Parqueo() {
    }
    
    public Parqueo(int id, String lugarParqueo, int numeroParqueo, LocalTime horaInicio, LocalTime horaSalida, Boolean habilitado, Vehiculo idTablaVehiculo) {
        this.id = id;
        this.lugarParqueo = lugarParqueo;
        this.numeroParqueo = numeroParqueo;
        this.horaInicio = horaInicio;
        this.horaSalida = horaSalida;
        this.habilitado = habilitado;
        this.idTablaVehiculo = idTablaVehiculo;
    }

    public Parqueo(String lugarParqueo, int numeroParqueo, LocalTime horaInicio, LocalTime horaSalida, Boolean habilitado, Vehiculo idTablaVehiculo) {
        this.lugarParqueo = lugarParqueo;
        this.numeroParqueo = numeroParqueo;
        this.horaInicio = horaInicio;
        this.horaSalida = horaSalida;
        this.habilitado = habilitado;
        this.idTablaVehiculo = idTablaVehiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLugarParqueo() {
        return lugarParqueo;
    }

    public void setLugarParqueo(String lugarParqueo) {
        this.lugarParqueo = lugarParqueo;
    }

    public int getNumeroParqueo() {
        return numeroParqueo;
    }

    public void setNumeroParqueo(int numeroParqueo) {
        this.numeroParqueo = numeroParqueo;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Vehiculo getIdTablaVehiculo() {
        return idTablaVehiculo;
    }

    public void setIdTablaVehiculo(Vehiculo idTablaVehiculo) {
        this.idTablaVehiculo = idTablaVehiculo;
    }

    @Override
    public String toString() {
        return "Parqueo{" + "id=" + id + ", lugarParqueo=" + lugarParqueo + ", numeroParqueo=" + numeroParqueo + ", horaInicio=" + horaInicio + ", horaSalida=" + horaSalida + ", habilitado=" + habilitado + ", idTablaVehiculo=" + idTablaVehiculo + '}';
    }
}
