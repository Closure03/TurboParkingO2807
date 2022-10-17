/*
 * En estos paquetes y clases se controlan las páginas web
 */
package com.turboparking.controladores;

import com.turboparking.entidades.Parqueo;
import com.turboparking.entidades.Usuario;
import com.turboparking.entidades.Vehiculo;
import com.turboparking.servicios.ParqueoServicio;
import com.turboparking.servicios.UsuarioServicio;
import com.turboparking.servicios.VehiculoServicio;
import static java.lang.Math.round;
import java.util.ArrayList;
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

    @Autowired
    private ParqueoServicio servicioParqueo;

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

    //MODIFICAR VEHICULO
    @GetMapping("/{id}/vehiculo/modificar")
    public String mostrarModificarVehiculo(@PathVariable int id, Model model) {
        model.addAttribute("vehiculo", servicioVehiculo.cargarVehiculoId(id));
        model.addAttribute("usuario", servicioVehiculo.cargarVehiculoId(id).getUsuario());
        return "modificarvehiculo";
    }

    @PostMapping("/vehiculo/actualizado")
    public String modificarVehiculo(@ModelAttribute Vehiculo vehiculo) {
        int id = vehiculo.getUsuario().getId();
        servicioVehiculo.guardarVehiculo(vehiculo);

        return "redirect:/" + id;
    }

    //ELIMINAR VEHICULO
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
    //Controller Parqueadero
    //Creación de parqueos
    @GetMapping("/parqueo/{id}")
    public String mostrarRegistroParqueo(@PathVariable int id, Model model) {
        Usuario user = servicio.consultarUsuario(id);
        List<Vehiculo> listaVeh = servicioVehiculo.cargarVehiculoUsuario(user);

        model.addAttribute("parqueo", new Parqueo());
        model.addAttribute("vehiculo", listaVeh);
        return "parqueadero";
    }

    @PostMapping("/parqueo/creacion")
    public String crearParqueo(@ModelAttribute Parqueo parking) {
        int id = parking.getIdTablaVehiculo().getUsuario().getId();
        parking.setHabilitado(true);
        parking.setNumeroParqueo((int) round(Math.random() * 100));
        servicioParqueo.crearParqueo(parking);

        return "redirect:/" + id;
    }

    //consulta de parqueos
    /*
    @GetMapping("/parqueo/consulta/{id}")
    public String consultarParqueo(@PathVariable int id, Model model) {
        List<Parqueo> parqueo = new ArrayList<>();
        Usuario user = servicio.consultarUsuario(id);
        List<Vehiculo> veh = servicioVehiculo.cargarVehiculoUsuario(user);

        for (Vehiculo vehiculo : veh) {
            parqueo.add(servicioParqueo.consultarParqueoVehiculo(vehiculo));
        }
        
        model.addAttribute("listParqueo", parqueo);
        return "parqueoreservado";
    }
    */
    @GetMapping("/parqueo/consulta/{id}")
    public String consultarParqueo(@PathVariable int id, Model model) {
        List<Parqueo> parqueos =  new ArrayList<>();
        Usuario user = servicio.consultarUsuario(id);
        List<Vehiculo> veh = servicioVehiculo.cargarVehiculoUsuario(user);
        List<Parqueo> todosParqueos = servicioParqueo.consultarTodosParqueo();
         
        for (Vehiculo vehiculo : veh) {
            for (Parqueo parking : todosParqueos) {
                if (vehiculo.getId() == parking.getIdTablaVehiculo().getId()) {
                parqueos.add(servicioParqueo.consultarParqueoVehiculo(vehiculo));
            }
            }
        }
        System.out.println(parqueos);
        model.addAttribute("listParqueo", parqueos);
        return "parqueoreservado";
    }

    @GetMapping("/parqueo/eliminar/{id}")
    public String eliminacionParqueo(@PathVariable int id) {
        int ident = servicioParqueo.consultarParqueoId(id).getIdTablaVehiculo().getUsuario().getId();
        servicioParqueo.eliminarParqueo(id);

        return "redirect:/" + ident;
    }
    
    //Modificar Parqueo
        //Loader
    @GetMapping("/loader")
    public String mostrarLoader(){
        return "loader";
    }
    
    @GetMapping("/parqueo/modificar/{id}")
    public String modificacionParqueo(@PathVariable int id, Model model){
        List<Vehiculo> vehiculosSinParking = new ArrayList<>();
        Parqueo parking = servicioParqueo.consultarParqueoId(id);
        Usuario user = servicioParqueo.consultarParqueoId(id).getIdTablaVehiculo().getUsuario();
        List<Vehiculo> vehList = servicioVehiculo.cargarVehiculoUsuario(user);
        
        for(Vehiculo veh : vehList){
            if (veh.getId() != parking.getIdTablaVehiculo().getId()) {
                vehiculosSinParking.add(veh);
            }
            
        }
        
        model.addAttribute("vehiculo", vehiculosSinParking);
        model.addAttribute("parqueo", parking);
        
        return "modificarparqueo";
    }
    
    @PostMapping("/parqueo/modificado")
    public String parqueoModificado(@ModelAttribute Parqueo parking){
        int id = parking.getIdTablaVehiculo().getUsuario().getId();
        servicioParqueo.actualizarParqueo(parking);
        
        return "redirect:/" + id;
    }

    @GetMapping("/parqueo/pdf/{id}")
    public String parqueoPdf(@PathVariable int id, Model model) {
        int ident = servicioParqueo.consultarParqueoId(id).getIdTablaVehiculo().getUsuario().getId();
        
        model.addAttribute("parqueoPdf", servicioParqueo.consultarParqueoId(id));
        
        return "redirect:/parqueo/consulta/" + ident;
    }
}
