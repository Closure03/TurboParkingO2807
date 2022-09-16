/*
 * En estos paquetes y clases se controlan las páginas web
 */
package com.turboparking.controladores;

import com.turboparking.entidades.Usuario;
import com.turboparking.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorPrincipal {
    
    @Autowired
    private UsuarioServicio servicio;
    
    //Aca se envia el controlador de URL 
    @GetMapping("/")
    public String cargarPaginaPrincipal() {
        return "index";
    }
    
    @GetMapping("/funcionamiento")
    public String cargarFuncionamiento() {
        return "funcionamiento";
    }
    
    @GetMapping("inicio-sesion")
    public String cargarInicioSesion() {
        return "iniciosesion";
    }
    
    @GetMapping("registro")
    public String cargarRegistro() {
        return "registro";
    }
    
    @GetMapping("lista/usuario")
    public String cargarListaUsuario(Model model, @RequestParam(value="criterio", required=false) String criterio) {
        if (criterio == null) {
            model.addAttribute("usuarios", servicio.consultarTodosUsuarios());
        } else {
            model.addAttribute("usuarios", servicio.consultarUsuarioNombreOCedula(criterio));
        }
        return "listausuario";
    }
    
    @GetMapping("registro/usuario")
    public String cargarRegistroUsuario(Model modelo) {
        Usuario nuevoUsuario = new Usuario();
        modelo.addAttribute("objetoUsuario", nuevoUsuario);
        return "registrousuario";
    }
    
    //VA CONECTADO CON EL REGISTRO DE USUARIO
    @PostMapping("/")
    public String guardarGenero(@ModelAttribute Usuario user) {
        servicio.crearUsuario(user);
        return "redirect:/inicio-sesion";
    }
 
    @PostMapping("/inicio-sesion/validado")
    public String comprobarInicioSesion(@RequestParam(value="criterioUsu", required=true) String correo, @RequestParam(value="criterioContra", required=true) String contra) {    
        Boolean bandera = servicio.inicioSesion(correo, contra);
        
        if (bandera) {
            return "redirect:/";
        } 
        return "iniciosesion";
    }
}
