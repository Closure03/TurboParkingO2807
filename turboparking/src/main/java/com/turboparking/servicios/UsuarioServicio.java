/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
    
    public List<Usuario> consultarUsuarioNombre(String nombre) {
        List<Usuario> listaUsuario = repo.findByNombre(nombre);
        return listaUsuario;
    }
    /*
    public List<Usuario> consultarTodosLosUsuario() {
        List<Usuario> contenido = repo.findAll();
        return contenido;
    }
    Para el ROL de administrador
    */
    public void eliminarUsuario(Usuario user) {
        repo.delete(user);
        //El método deleteAll() elimina todos los datos de la tabla
    }
}
