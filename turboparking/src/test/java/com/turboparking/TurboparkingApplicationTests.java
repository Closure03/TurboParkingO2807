package com.turboparking;

import com.turboparking.entidades.Usuario;
import com.turboparking.servicios.UsuarioServicio;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TurboparkingApplicationTests {
    //TESTEO PARA EL CRUD DE USUARIO
    @Autowired
    private UsuarioServicio miServicio;
    
    @Test
    @Disabled //Ya se testeo
    public void verificarSiSeGuardaUnUsuarioNuevo() {
            Usuario miNuevoUsuario = new Usuario("Andres", "441545462", "andre@gmail.com", "456123");
            Usuario contenido = miServicio.crearUsuario(miNuevoUsuario);        
            
            Assertions.assertTrue(contenido.getId() > 0, "Mensaje de Error, no se pudo crear el usuario");//Verificador para saber si esta funcionando
    }
 
    @Test
    @Disabled //Ya se testeo
    public void verificarSiSeActualizaUnUsuario() {
            Usuario miNuevoUsuario = new Usuario("Fabian", "8888462", "fabio@gmail.com", "12348556");
            Usuario contenido = miServicio.crearUsuario(miNuevoUsuario);        
            miNuevoUsuario.setNombre("Pepito");
            miNuevoUsuario.setCorreo("fabioHernandez@hotmail.com");
            Usuario actualizado = miServicio.actualizarUsuario(miNuevoUsuario);
            
            Assertions.assertTrue(actualizado.getNombre().equals("Pepito") , "no se pudo actualizar el usuario");
    }
   
    @Test
    @Disabled //Ya se testeo
    public void verificarConsultarUsuario() { 
            Usuario g = miServicio.consultarUsuario(13);
            System.out.println(g);
            Assertions.assertTrue(g != null, "Mensaje de Error, no se pudo consultar");//Verificador para saber si esta funcionando
    }
    
    @Test
    @Disabled //Ya se testeo
    public void verificarConsultaNombreOCedula() {
        List<Usuario> g;
        g = miServicio.consultarUsuarioNombreOCedula("441545462");
    }
    
    @Test
    @Disabled //Ya se testeo
    public void verificarConsultaCedula() {
        System.out.println(miServicio.consultarUsuarioCedula("441545462"));
    }
    
    @Test
    @Disabled //Ya se testeo
    public void verificarConsultaUsuarios() {
        miServicio.consultarTodosUsuarios();
    }  
    
    @Test
    public void verificarSiCorreoYcontrasenaFunciona() {
        System.out.println(miServicio.inicioSesion("angelo.com", "16"));
    }
    
    @Test
    public void verificarSiCorreoFunciona() {
        System.out.println(miServicio.consultaUsuarioCorero("fabian@gmail.com"));
    }
}
