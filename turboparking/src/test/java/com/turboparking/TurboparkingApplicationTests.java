package com.turboparking;

import com.turboparking.entidades.Usuario;
import com.turboparking.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TurboparkingApplicationTests {
    @Autowired
    private UsuarioServicio miServicio;
    
    @Test
    @Disabled
    void verificarSiSeGuardaUnUsuarioNuevo() {
            Usuario miNuevoUsuario = new Usuario("Andres", "441545462", "andre@gmail.com", "27/10/2002", "456123");
            Usuario contenido = miServicio.crearUsuario(miNuevoUsuario);        
            
            Assertions.assertTrue(contenido.getId() > 0, "Mensaje de Error, no se pudo crear el usuario");//Verificador para saber si esta funcionando
    }
    
    @Test
    void verificarSiSeActualizaUnUsuario() {
            Usuario miNuevoUsuario = new Usuario("Fabian", "8888462", "fabio@gmail.com", "30/10/2012", "12348556");
            Usuario contenido = miServicio.crearUsuario(miNuevoUsuario);        
            miNuevoUsuario.setNombre("Pepito");
            miNuevoUsuario.setHoraInicioActividad("31/10/2003");
            Usuario actualizado = miServicio.actualizarUsuario(miNuevoUsuario);
            
            Assertions.assertTrue(actualizado.getNombre().equals("Pepito") , "no se pudo actualizar el usuario");
    }
    
     @Test
    void verificarConsultarUsuario() { 
            Usuario g = miServicio.consultarUsuario(3);
            System.out.println(g);
            Assertions.assertTrue(g != null, "Mensaje de Error, no se pudo consultar");//Verificador para saber si esta funcionando
    }
}
