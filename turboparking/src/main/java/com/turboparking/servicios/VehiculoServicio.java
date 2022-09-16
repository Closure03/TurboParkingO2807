/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turboparking.servicios;

import com.turboparking.entidades.Vehiculo;
import com.turboparking.repositorios.IVehiculoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoServicio {
    
    @Autowired
    IVehiculoRepositorio vehiculoRepo;
    
    //CARGAR TODA LA LISTA DE VEHICULOS ENCONTRADOS
    public List<Vehiculo> cargarVehiculos() {
        return vehiculoRepo.findAll();
    } 
    
    //CARGAR TODOS LOS VEHICULOS QUE SEAN DE UN TIPO ESPECOFICO (MARCA)
    public List<Vehiculo> cargarVehiculoTipo(String criterio) {
        return vehiculoRepo.findBytipoVehiculoContaining(criterio);
    }
    
    //CARGAR EL VEHICULO CON LA MATRICULA
    public Vehiculo cargarVehiculoMatricula(String criterio) {
        return vehiculoRepo.findByMatriculaContaining(criterio);
    }
    
    //GUARDA VEHICULOS
    public Vehiculo guardarVehiculo(Vehiculo g) {
        return vehiculoRepo.save(g);
    }
    
    /*
    //ELIMINA VEHICULO POR MEDIO DE LA MATRICULA FORMA RAPIDA
    public void eliminarVehiculo(String matricula) {
        vehiculoRepo.deleteByMatricula(matricula);
    }
    */
    
    public boolean eliminarVehiculo(int id){
        Vehiculo miCarro = vehiculoRepo.findById(id).get();
        if (miCarro == null) {
            return false;
        } else {
            vehiculoRepo.deleteById(id);
            return true;
        }
    }
    
    public boolean eliminarVehiculoMatricula(String matricula) {
        Vehiculo miCarro = vehiculoRepo.findByMatriculaContaining(matricula);
        if(miCarro == null) {
            return false;
        }else {
            vehiculoRepo.deleteById(miCarro.getId());
            return true;
        }
    }
}
