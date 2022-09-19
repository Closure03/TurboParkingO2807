/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turboparking;

import com.turboparking.entidades.Usuario;
import com.turboparking.entidades.Vehiculo;
import com.turboparking.servicios.UsuarioServicio;
import com.turboparking.servicios.VehiculoServicio;
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
    
    @Test
    public void comprobarCreacionVehiculo() {
        Usuario miUsu = miUsuario.consultarUsuario(14);
        Vehiculo nuevoVehiculo = new Vehiculo("Mazda", "GGF-178", miUsu);
        
        Assertions.assertDoesNotThrow(() -> {
            miVehiculo.guardarVehiculo(nuevoVehiculo);
        }, "Error al guardar Vehiculo");
    }
    
    @Test
    public void comprobarCargarVehiculoMatricula() {
        Assertions.assertDoesNotThrow(() -> {
            miVehiculo.cargarVehiculoMatricula("GGF-178");
        }, "Error al consultar el Vehiculo en la matricula");
    }
    
    @Test
    public void comprobarCargarVehiculoTipo() {
        Assertions.assertDoesNotThrow(() -> {
            miVehiculo.cargarVehiculoTipo("Mazda");
        }, "Error al consultar el Vehiculo en la matricula");
    }
    
    @Test
    @Disabled
    public void eliminarVehiculo() {
        miVehiculo.eliminarVehiculo(5);
    }
    
    @Test
    @Disabled
    public void comprobarEliminarVehiculoMatricula() {
        miVehiculo.eliminarVehiculoMatricula("GTC-189");
    }
}
