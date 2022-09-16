/*
 * ACA ENVIAMOS LA INFORMACIÓN DE LA BASE DE DATOS POR MEDIO DE UNA API
 */
package com.turboparking.controladores;

import com.turboparking.entidades.Usuario;
import com.turboparking.servicios.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioControladorWeb {
    
    @Autowired
    private UsuarioServicio miServicio;
    
    @GetMapping("api/usuarios")
    public ResponseEntity<List<Usuario>> consultarUsuariosApi() {
        List<Usuario> lista = miServicio.consultarTodosUsuarios();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}



