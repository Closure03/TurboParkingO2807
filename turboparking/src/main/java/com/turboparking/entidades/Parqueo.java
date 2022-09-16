/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turboparking.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "tparqueos")
public class Parqueo {

    @Id
    @Column(name="id_tparqueos", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="num_puesto_tparqueos", nullable=false)
    private int numeroParqueo;
    
    @Column(name="hora_inicio_tparqueos", nullable=false, length=20)
    private String horaInicio;
    
    @Column(name="hora_salida_tparqueos", nullable=false, length=20)
    private String horaSalida;
    
    @ManyToOne
    @JoinColumn(name="id_tvehiculos", nullable=false)
    private Vehiculo idTablaVehiculo;

    public Parqueo(int id, int numeroParqueo, String horaInicio, String horaSalida, Vehiculo idTablaVehiculo) {
        this.id = id;
        this.numeroParqueo = numeroParqueo;
        this.horaInicio = horaInicio;
        this.horaSalida = horaSalida;
        this.idTablaVehiculo = idTablaVehiculo;
    }
    
    public Parqueo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroParqueo() {
        return numeroParqueo;
    }

    public void setNumeroParqueo(int numeroParqueo) {
        this.numeroParqueo = numeroParqueo;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Vehiculo getIdTablaVehiculo() {
        return idTablaVehiculo;
    }

    public void setIdTablaVehiculo(Vehiculo idTablaVehiculo) {
        this.idTablaVehiculo = idTablaVehiculo;
    }

    @Override
    public String toString() {
        return "Parqueo{" + "id=" + id + ", numeroParqueo=" + numeroParqueo + ", horaInicio=" + horaInicio + ", horaSalida=" + horaSalida + ", idTablaVehiculo=" + idTablaVehiculo + '}';
    }
}
