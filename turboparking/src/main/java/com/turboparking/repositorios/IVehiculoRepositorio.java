/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.turboparking.repositorios;

import com.turboparking.entidades.Usuario;
import com.turboparking.entidades.Vehiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiculoRepositorio extends JpaRepository<Vehiculo, Integer> {
    /*
    *DE ESTA INTERFAZ VAMOS A LLAMAR TODOS LOS METODOS CRUD,
    TAMBIÉN CREAR MÉTODOS CRUD.
    */
    
    public List<Vehiculo> findBytipoVehiculoContainingOrMatriculaContaining(String tipoNombre, String matricula);
    
    public Vehiculo findById(int id);
    
    public Vehiculo findByMatriculaContaining(String matricula);
    
    public List<Vehiculo> findByUsuarioIs(Usuario user);
}
