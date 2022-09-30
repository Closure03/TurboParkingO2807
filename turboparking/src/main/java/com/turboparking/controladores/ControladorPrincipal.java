/*
 * En estos paquetes y clases se controlan las páginas web
 */
package com.turboparking.controladores;

import com.turboparking.entidades.Usuario;
import com.turboparking.entidades.Vehiculo;
import com.turboparking.servicios.UsuarioServicio;
import com.turboparking.servicios.VehiculoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorPrincipal {

    @Autowired
    private UsuarioServicio servicio;

    @Autowired
    private VehiculoServicio servicioVehiculo;

    //Aca se envia el controlador de URL 
    @GetMapping("/")
    public String cargarPaginaPrincipal() {
        return "index";
    }

    @GetMapping("/funcionamiento")
    public String cargarFuncionamiento() {
        return "funcionamiento";
    }

    //CONTROLADORES DE USUARIO
    //ACA ENVIAMOS EL INDEX CUANDO YA HAYA INICIADO SESIÓN
    @GetMapping("/{id}")
    public String cargarPrincipalSesion(Model model, @PathVariable int id) {
        Usuario user = servicio.consultarUsuario(id);
        model.addAttribute("usuario", user);
        return "indexsesion";
    }

    //ACTUALIZAR LOS DATOS DEL USUARIO, TENIENDO EN CUENTA EL ID POR MEDIO DE LA URL
    @GetMapping("/{id}/perfil")
    public String cargarPerfilSesion(Model model, @PathVariable int id) {
        Usuario user = servicio.consultarUsuario(id);
        model.addAttribute("usuario", user);
        return "perfil";
    }

    //MÉTODO POST PARA ENVIAR EL NUEVO USUARIO ACTUALIZADO
    @PostMapping("/{id}")
    public String actualizarPerfilSesion(@ModelAttribute Usuario g) {
        servicio.actualizarUsuario(g);
        int id = g.getId();
        return "redirect:/" + id;
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCuentaUsuario(@PathVariable int id) {
        servicio.eliminarUsuario(id);
        return "redirect:/";
    }

    /*
    //PERFIL DE LOS USUARIOS
    @GetMapping("/perfil/${id}")
    public String cargarPerfilUsuario(Model model, @PathVariable int id) {
        Usuario user = servicio.consultarUsuario(id);
        model.addAttribute("usuario", user);
        return "indexsesion";
    }
     */
    @GetMapping("inicio-sesion")
    public String cargarInicioSesion() {
        return "iniciosesion";
    }

    @GetMapping("lista/usuario")
    public String cargarListaUsuario(Model model, @RequestParam(value = "criterio", required = false) String criterio) {
        if (criterio == null) {
            model.addAttribute("usuarios", servicio.consultarTodosUsuarios());
        } else {
            model.addAttribute("usuarios", servicio.consultarUsuarioNombreOCedula(criterio));
        }
        return "listausuario";
    }

    @GetMapping("registro")
    public String cargarRegistro() {
        return "registro";
    }

    @GetMapping("registro/usuario")
    public String cargarRegistroUsuario(Model modelo) {
        Usuario nuevoUsuario = new Usuario();
        modelo.addAttribute("objetoUsuario", nuevoUsuario);
        return "registrousuario";
    }

    //VA CONECTADO CON EL REGISTRO DE USUARIO
    @PostMapping("/")
    public String guardarUsuario(@ModelAttribute Usuario user) {
        servicio.crearUsuario(user);
        return "redirect:/inicio-sesion";
    }

    @PostMapping("/inicio-sesion/validado")
    public String comprobarInicioSesion(@RequestParam(value = "criterioUsu", required = true) String correo, @RequestParam(value = "criterioContra", required = true) String contra) {
        Boolean bandera = servicio.inicioSesion(correo, contra);
        if (bandera) {
            Usuario user = servicio.consultaUsuarioCorero(correo);
            int id = user.getId();
            return "redirect:/" + id;
        }
        return "iniciosesion";
    }

    //CONTROLADORES DE VEHICULO
    @GetMapping("lista/vehiculo")
    public String cargarListaVehiculo(Model model, @RequestParam(value = "criterio", required = false) String criterio) {
        if (criterio == null) {
            model.addAttribute("vehiculos", servicioVehiculo.cargarVehiculos());
        } else {
            model.addAttribute("vehiculos", servicioVehiculo.cargarVehiculoTipo(criterio));
        }
        return "listavehiculo";
    }

    //VA CONECTADO CON EL REGISTRO DE VEHICULO
    @PostMapping("/registro")
    public String guardarVehiculo(@ModelAttribute Vehiculo vehiculo) {
        servicioVehiculo.guardarVehiculo(vehiculo);
        return "redirect:/lista/vehiculo";
    }

    //URL PARA CONSULTAR LOS VEHICULOS
    @GetMapping("/{id}/vehiculo")
    public String cargarVehiculo(Model model, @PathVariable int id) {
        Usuario user = servicio.consultarUsuario(id);
        List<Vehiculo> veh = servicioVehiculo.cargarVehiculoUsuario(user);
        model.addAttribute("vehiculo", veh);
        model.addAttribute("user", user);
        
        return "vehiculo";
    }
    
    @PostMapping("/{id}/vehiculo/actualizado")
    public String actualizarVehiculo(@ModelAttribute Vehiculo vehiculo, @PathVariable int id) {
        servicioVehiculo.guardarVehiculo(vehiculo);
        return "redirect:/" + id;
    }
    
    @GetMapping("/eliminar/vehiculo/{id}")
    public String eliminarVehiculo(@PathVariable int id) {
        Vehiculo veh = servicioVehiculo.cargarVehiculoId(id);
        Usuario usu = veh.getUsuario();
        int ident = usu.getId();
        
        servicioVehiculo.eliminarVehiculo(id);

        return "redirect:/" + ident;
    }

    //URL PARA REGISTRAR VEHICULOS
    @GetMapping("/{id}/vehiculo/registro")
    public String cargarRegistroDeVehiculo(Model model, @PathVariable int id) {
        model.addAttribute("objetoVehiculo", new Vehiculo());
        model.addAttribute("user", servicio.consultarUsuario(id));

        return "registrovehiculo";
    }
    
    @PostMapping("/vehiculo/registro/validado")
    public String envioDeRegistroUsuarioDeVehiculo(@ModelAttribute Vehiculo veh, @RequestParam(value = "identificador", required = true) String identificador) {
        if ("".equals(veh.getApodoVehiculo())) {
            veh.setApodoVehiculo("Vehiculo");
            servicioVehiculo.guardarVehiculo(veh);
        }
        
        servicioVehiculo.guardarVehiculo(veh);

        return "redirect:/" + identificador;
    }
    
    /*
    @PostMapping("/vehiculo/registro/validado")
    public String envioDeRegistroUsuarioDeVehiculo(@ModelAttribute Vehiculo veh, @RequestParam(value = "usuario", required = false) Usuario usuario) {

        veh.setUsuario(usuario);
        
        if ("".equals(veh.getApodoVehiculo())) {
            veh.setApodoVehiculo("Vehiculo");
            servicioVehiculo.guardarVehiculo(veh);
        }

        servicioVehiculo.guardarVehiculo(veh);

        return "indexsesion";
    }
    */
}
