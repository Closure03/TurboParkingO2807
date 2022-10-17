/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.turboparking.repositorios;

import com.turboparking.entidades.Parqueo;
import com.turboparking.entidades.Vehiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParqueoRepositorio extends JpaRepository<Parqueo, Integer> {
    
    //Nuestros servicios, donde extraemos metodos personalizados y cruds
    public Parqueo findById(int id);
    
    public List<Parqueo> findByHabilitado(Boolean ocupado);
    
    public Parqueo findByidTablaVehiculo(Vehiculo veh);
}
