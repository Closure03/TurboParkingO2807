/*
 * En estos paquetes y clases se controlan las páginas web
 */
package com.turboparking.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPrincipal {
    
    //Aca se envia el controlador de URL 
    @GetMapping("/")
    public String cargarPaginaPrincipal() {
        return "index";
    }
    
    @GetMapping("inicio-sesion")
    public String cargarInicioSesion() {
        return "inicio_sesion";
    }
}
