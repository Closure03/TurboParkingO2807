/*
 * ACA SE GUSRDAN LOS MÉTODOS CRUD DE USUARIO
 */
package com.turboparking.servicios;

import com.turboparking.entidades.Usuario;
import com.turboparking.repositorios.IUsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
    
    @Autowired
    private IUsuarioRepositorio repo;
    
    public Usuario crearUsuario(Usuario user) {
        Usuario guardado = repo.save(user); //Guarda el Usuario pasado por el parametro
        return guardado;
    }

    public Usuario actualizarUsuario(Usuario user) {
        Usuario actualizado = repo.save(user);
        return actualizado;
    }
    
    public Usuario consultarUsuario(int id) {
        Usuario contenido = repo.findById(id).get();
        //Busco el objeto por el id, y con el .get() lo que hago es que me traigo todo ese objeto
        return contenido;
    }
    
    public List<Usuario> consultarTodosUsuarios() {
        List<Usuario> g = repo.findAll();
        return g;
    }
    
    public List<Usuario> consultarUsuarioNombreOCedula(String nombre) {
        List<Usuario> listaUsuario = repo.findByNombreContainingOrCedulaContaining(nombre, nombre);
        return listaUsuario;
    }
    
    public List<Usuario> consultarUsuarioCedula(String cedula) {
        return repo.findBycedula(cedula);
    }
    /*
    public List<Usuario> consultarTodosLosUsuario() {
        List<Usuario> contenido = repo.findAll();
        return contenido;
    }
    Para el ROL de administrador
    */
    public void eliminarUsuario(int id) {
        repo.deleteById(id);
        //El método deleteAll() elimina todos los datos de la tabla
    }
    
    public void eliminarUsuarioObjeto(Usuario user) {
        repo.delete(user);
    }
    
    public Boolean inicioSesion(String correo, String contra){
        Boolean bandera = true;
        Usuario user = repo.findByCorreoAndContrasena(correo, contra);
        if (user == null) {
            bandera = false;
        }
        return bandera;
    }
    
    public Usuario consultaUsuarioCorero(String correo) {
        Usuario user = repo.findByCorreoContaining(correo);
        return user;
    }
}
