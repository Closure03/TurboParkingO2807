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
import javax.persistence.Table;

@Entity
@Table(name="tvehiculos")
public class Vehiculo {
    @Id
    @Column(name="id_tvehiculos", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="tipo_tvehiculos", nullable=false, length=30)
    private String tipoVehiculo;
    
    @Column(name="matricula_tvehiculos", nullable=false, length=30)
    private String matricula;
    
    @ManyToOne
    @JoinColumn(name="id_tusuarios")
    private Usuario idTablaUsuario;

    public Vehiculo(int id, String tipoVehiculo, String matricula, Usuario idTablaUsuario) {
        this.id = id;
        this.tipoVehiculo = tipoVehiculo;
        this.matricula = matricula;
        this.idTablaUsuario = idTablaUsuario;
    }

    public Vehiculo(String tipoVehiculo, String matricula, Usuario idTablaUsuario) {
        this.tipoVehiculo = tipoVehiculo;
        this.matricula = matricula;
        this.idTablaUsuario = idTablaUsuario;
    }
    

    public Vehiculo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Usuario getIdTablaUsuario() {
        return idTablaUsuario;
    }

    public void setIdTablaUsuario(Usuario idTablaUsuario) {
        this.idTablaUsuario = idTablaUsuario;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", tipoVehiculo=" + tipoVehiculo + ", matricula=" + matricula + ", idTablaUsuario=" + idTablaUsuario + '}';
    }
}