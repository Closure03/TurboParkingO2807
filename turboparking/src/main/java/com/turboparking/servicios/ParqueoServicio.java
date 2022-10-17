/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turboparking.servicios;

import com.turboparking.entidades.Parqueo;
import com.turboparking.entidades.Vehiculo;
import com.turboparking.repositorios.IParqueoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParqueoServicio {
    
    @Autowired
    private IParqueoRepositorio repoParqueo;
    
    //Creación de Métodos CRUD a partir del REPO
    public List<Parqueo> consultarTodosParqueo() {
        return repoParqueo.findAll();
    }
    
    public Parqueo consultarParqueoId(int id) {
        return repoParqueo.findById(id);
    }
    
    public List<Parqueo> consultarParqueosHabilitados(Boolean ocupado) {
        return repoParqueo.findByHabilitado(ocupado);
    }
    
    public Parqueo consultarParqueoVehiculo(Vehiculo veh) {
        return repoParqueo.findByidTablaVehiculo(veh);
    }
    
    public Parqueo crearParqueo(Parqueo parking){
        return repoParqueo.save(parking);
    }
    
    public Parqueo actualizarParqueo(Parqueo parking) {
        return repoParqueo.save(parking);
    }
    
    public void eliminarParqueo(int id) {
        repoParqueo.deleteById(id);
    }
}
