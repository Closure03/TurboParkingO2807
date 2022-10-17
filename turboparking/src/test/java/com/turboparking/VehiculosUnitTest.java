/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turboparking;

import com.turboparking.entidades.Usuario;
import com.turboparking.entidades.Vehiculo;
import com.turboparking.servicios.UsuarioServicio;
import com.turboparking.servicios.VehiculoServicio;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VehiculosUnitTest {
    
    @Autowired
    private VehiculoServicio miVehiculo;
    
    @Autowired
    private UsuarioServicio miUsuario;
    /*
    @Test
    @Disabled //Ya testeado
    public void comprobarCreacionVehiculoSinApodo() {
        Usuario miUsu = miUsuario.consultarUsuario(17);
        Vehiculo nuevoVehiculo = new Vehiculo("Honda", "HHG-123", miUsu);
        
        if(nuevoVehiculo.getApodoVehiculo() == null){
            nuevoVehiculo.setApodoVehiculo("Vehiculo");
        }
        
        Assertions.assertDoesNotThrow(() -> {
            miVehiculo.guardarVehiculo(nuevoVehiculo);
        }, "Error al guardar Vehiculo");
    }
    
    @Test
    @Disabled //Ya se testeo
    public void comprobarCreacionVehiculoConApodo() {
        Usuario miUsu = miUsuario.consultarUsuario(15);
        Vehiculo nuevoVehiculo = new Vehiculo("Turbina", "Renault", "SVG-F56", miUsu);
        
        Assertions.assertDoesNotThrow(() -> {
            miVehiculo.guardarVehiculo(nuevoVehiculo);
        }, "Error al guardar Vehiculo");
    }
    
    @Test
    @Disabled //Ya se testeo
    public void comprobarCargarVehiculoMatricula() {
        Assertions.assertDoesNotThrow(() -> {
            miVehiculo.cargarVehiculoMatricula("SVG-F56");
        }, "Error al consultar el Vehiculo en la matricula");
    }
    
    @Test
    @Disabled //Ya se testeo
    public void comprobarCargarVehiculoTipo() {
        Assertions.assertDoesNotThrow(() -> {
            miVehiculo.cargarVehiculoTipo("Kia");
        }, "Error al consultar el Vehiculo en la matricula");
    }
    
    @Test
    @Disabled //Ya se testeo
    public void eliminarVehiculo() {
        miVehiculo.eliminarVehiculo(11);
    }
    
    @Test
    @Disabled //Ya se testeo
    public void comprobarEliminarVehiculoMatricula() {
        miVehiculo.eliminarVehiculoMatricula("GGF-178");
    }
    
    @Test
    @Disabled //Ya testeado
    public void consultarVehiculo() {
        miVehiculo.cargarVehiculos();
    }
    
    @Test
    @Disabled //Ya testeado
    public void comprobarConsultaDeVehiculoPorUsuario() {
        Usuario miUsu = miUsuario.consultarUsuario(15);
        List<Vehiculo> lista = miVehiculo.cargarVehiculoUsuario(miUsu);
        
        for (Vehiculo vehiculo : lista) {
            System.out.println(vehiculo);
        }
    }
    */
}
