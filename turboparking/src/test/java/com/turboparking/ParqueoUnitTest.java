/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turboparking;

import com.turboparking.entidades.Parqueo;
import com.turboparking.entidades.Usuario;
import com.turboparking.entidades.Vehiculo;
import com.turboparking.servicios.ParqueoServicio;
import com.turboparking.servicios.UsuarioServicio;
import com.turboparking.servicios.VehiculoServicio;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ParqueoUnitTest {
    
    @Autowired
    private UsuarioServicio usuService;
    
    @Autowired
    private VehiculoServicio vehService;
    
    @Autowired
    private ParqueoServicio parqueoService;
    /*
     @Test
     @Disabled //Ya testeado
     public void comprobacionCreacionParqueos() {
         Vehiculo veh = vehService.cargarVehiculoId(37);
         Parqueo parking = new Parqueo("Paseo de los Libertadores", 4, LocalTime.of(18, 10, 15), LocalTime.of(17, 30, 00), false, veh);
         
         parqueoService.crearParqueo(parking);
     }
     
     @Test
     @Disabled //Ya testeado
     public void comprobaciónActualizacionParqueo() {
         Parqueo parking = parqueoService.consultarParqueoId(1);
         parking.setLugarParqueo("San Patricio");
         
         parqueoService.actualizarParqueo(parking);
     }
     
     @Test 
     @Disabled //Ya testeado
     public void comprobacionConsultaParqueos() {
         parqueoService.consultarTodosParqueo();
     }
     
     @Test
     @Disabled //Ya testeado
     public void comprobacionConsultaParqueoHabilitado() {
         parqueoService.consultarParqueosHabilitados(false);
     }
     
     @Test
     @Disabled //Ya testeado
     public void comprobacionEliminacionParqueo() {
         parqueoService.eliminarParqueo(5);
     }
     
     @Test
     @Disabled //Ya testeado
     public void comprobacionConsultaParqueoVehiculo() {
         List<Parqueo> parqueos =  new ArrayList<>();
         Usuario user = usuService.consultarUsuario(15);
         List<Vehiculo> veh = vehService.cargarVehiculoUsuario(user);
         
         for (Vehiculo vehiculo : veh) {
             parqueos.add(parqueoService.consultarParqueoVehiculo(vehiculo));
         }
     }
     */
}
