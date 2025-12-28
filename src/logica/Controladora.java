package logica;

import igu.VerUsuarios;
import java.time.LocalDateTime;
import java.util.List;
import persistencia.ControladoraPersistencia;

/**
 * Clase encargada de coordinar la lógica de negocio del sistema de peluquería
 * canina.
 *
 * Esta clase gestiona la creación, modificación, eliminación y recuperación de
 * datos relacionados con mascotas y sus dueños, utilizando la capa de
 * persistencia.
 *
 * @author Alicia
 */
public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    private VerUsuarios frm;
    private Usuarios mod;
    private Mascotas masc;

    /**
     * Constructor por defecto.
     */
    public Controladora() {

    }

    /**
     * Constructor que recibe referencias a componentes de la interfaz y
     * modelos.
     *
     * @param frm Vista de usuarios.
     * @param mod Modelo de datos de usuario.
     */
    public Controladora(VerUsuarios frm, Usuarios mod) {
        this.frm = frm;
        this.mod = mod;

    }
    
    

    /**
     * Crea y guarda una nueva mascota junto con su dueño en la base de datos.
     *
     * @param nombreMasco Nombre de la mascota.
     * @param raza Raza de la mascota.
     * @param color Color de la mascota.
     * @param observaciones Observaciones adicionales.
     * @param alergia Información sobre alergias.
     * @param atenEsp Necesidades de atención especial.
     * @param nombreDuenio Nombre del dueño.
     * @param telefono Teléfono del dueño.
     * @param serviciosSeleccionados tipos de servicios para las mascotas
     */
    public void guardar(String nombreMasco, String raza, String color, String observaciones,
            String alergia, String atenEsp, String nombreDuenio, String telefono, List<Servicios> serviciosSeleccionados) {

        // Creamos el duenio y asignamos sus valores
        Duenio duenio = new Duenio();

        duenio.setNombre(nombreDuenio);
        duenio.setTelefono(telefono);

        // Creamos la mascota y asignamos sus valores
        Mascotas masco = new Mascotas();

        masco.setNombreMas(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergia);
        masco.setAtencion_especial(atenEsp);
        masco.setObservaciones(observaciones);
        masco.setUnDuenio(duenio);  // asignamos el id del duenio

        // Asignar servicios seleccionados
        masco.setServicios(serviciosSeleccionados);
////        masco.setn(serviciosSeleccionados);

        controlPersis.guardar(duenio, masco);
    }

    /**
     * Recupera la lista completa de mascotas registradas.
     *
     * @return Lista de objetos Mascotas.
     */
    public List<Mascotas> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    /**
     * Elimina una mascota y su dueño asociado según el número de cliente.
     *
     * @param num_cliente Identificador único del cliente.
     */
    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    /**
     * Recupera una mascota específica por su número de cliente.
     *
     * @param num_cliente Identificador único de la mascota.
     * @return Objeto Mascotas correspondiente.
     */
    public Mascotas traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    /**
     * Modifica los datos de una mascota y su dueño asociado.
     *
     * @param masco Mascota a modificar.
     * @param nombreMasco Nuevo nombre de la mascota.
     * @param raza Nueva raza.
     * @param color Nuevo color.
     * @param observaciones Nuevas observaciones.
     * @param alergia Nueva información de alergia.
     * @param atenEsp Nueva atención especial.
     * @param nombreDuenio Nuevo nombre del dueño.
     * @param telefono Nuevo teléfono del dueño.
     * @param serviciosSeleccionados Tipos de servicios para las mascotas
     */
    public void modificarMascota(Mascotas masco, String nombreMasco, String raza, String color,
            String observaciones, String alergia, String atenEsp,
            String nombreDuenio, String telefono,
            List<Servicios> serviciosSeleccionados) {
        // Actualizar datos de la mascota
        masco.setNombreMas(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergia);
        masco.setAtencion_especial(atenEsp);

        // Actualizar servicios seleccionados
        masco.setServicios(serviciosSeleccionados);
        // masco.setNombre_servicios(serviciosSeleccionados);

        // Persistir cambios de la mascota
        controlPersis.modificarMascota(masco);

        // Actualizar datos del dueño
        Duenio duenio = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        duenio.setTelefono(telefono);
        duenio.setNombre(nombreDuenio);

        // Persistir cambios del dueño
        this.modificarDuenio(duenio);
    }

    /*public void modificarMascota(Mascotas masco, String nombreMasco, String raza, String color, String observaciones, String alergia, String atenEsp, String nombreDuenio, String telefono) {
        masco.setNombreMas(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergia);
        masco.setAtencion_especial(atenEsp);

        // modifico la mascota
        controlPersis.modificarMascota(masco);
        // nuevos valores ddel dueño
        Duenio duenio = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        duenio.setTelefono(telefono);
        duenio.setNombre(nombreDuenio);

        // llamar al modificarDueño
        this.modificarDuenio(duenio);
    }*/
    /**
     * Busca un dueño por su identificador.
     *
     * @param id_duenio Identificador único del dueño.
     * @return Objeto Duenio correspondiente.
     */
    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    /**
     * Modifica los datos de un dueño en la base de datos.
     *
     * @param duenio Objeto Duenio con los datos actualizados.
     */
    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarDuenio(duenio);
    }

    // ------------------- CRUD Usuarios -------------------
    /**
     * Crea y guarda un nuevo usuario junto con su rol en la base de datos.
     *
     * @param nombre Nombre del usuario.
     * @param apellidos Apellidos del usuario.
     * @param email Correo electrónico.
     * @param pass Contraseña.
     * @param nombreRol Nombre del rol asignado (ej. ADMIN, RECEPCIONISTA).
     */
    public void guardarUsuario(String nombre, String apellidos, String email, String pass, String nombreRol) {
        // Buscar rol existente en la base de datos
        Rol rol = null;
        for (Rol r : controlPersis.traerRoles()) {
            if (r.getNombre().equalsIgnoreCase(nombreRol)) {
                rol = r;
                break;
            }
        }

        // Si el rol no existe, lanzamos error (no lo creamos automáticamente)
        if (rol == null) {
            throw new IllegalArgumentException("El rol '" + nombreRol + "' no existe en la base de datos.");
        }

        // Crear el usuario y asignar valores
        Usuarios usuario = new Usuarios();
        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setEmail(email);
        usuario.setPass(pass);
        usuario.setTipo_rol(rol);  // asignamos el rol existente

        // Guardar usuario
        controlPersis.guardarUsuario(usuario);

    }

    /**
     * Recupera la lista completa de usuarios registrados.
     *
     * @return Lista de objetos Usuarios.
     */
    public List<Usuarios> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    /**
     * Elimina un usuario según su ID.
     *
     * @param id_usuario Identificador único del usuario.
     */
    public void borrarUsuario(int id_usuario) {
        controlPersis.borrarUsuario(id_usuario);
    }

    /**
     * Recupera un usuario específico por su ID.
     *
     * @param id_usuario Identificador único del usuario.
     * @return Objeto Usuarios correspondiente.
     */
    public Usuarios traerUsuario(int id_usuario) {
        return controlPersis.traerUsuario(id_usuario);
    }

    /**
     * Modifica un usuario específico por su ID.
     *
     * @param usuario Identificador único del usuario. 
     */
    public void modificarUsuario(Usuarios usuario) {
        controlPersis.modificarUsuario(usuario);
    }

    /**
     * Inicia sesión verificando email y contraseña.
     *
     * @param email Correo electrónico del usuario.
     * @param pass Contraseña del usuario.
     * @return Usuario si las credenciales son correctas, null si no coinciden.
     */
    public Usuarios iniciarSesion(String email, String pass) {
        return controlPersis.iniciarSesion(email, pass);
    }

    
    // ------------------- CRUD Roles -------------------
    
    /**
     * Guarda un nuevo rol en la base de datos.
     *
     * @param nombre Nombre del rol.
     */
    public void guardarRol(String nombre) {
        Rol rol = new Rol(nombre);
        controlPersis.guardarRol(rol);
    }

    /**
     * Recupera la lista completa de roles registrados.
     *
     * @return Lista de objetos Rol.
     */
    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    /**
     * Recupera un rol específico por su ID.
     *
     * @param id_rol Identificador único del rol.
     * @return Objeto Rol correspondiente.
     */
    public Rol traerRol(int id_rol) {
        return controlPersis.traerRol(id_rol);
    }

    /**
     * Modifica los datos de un rol existente.
     *
     * @param rol Rol a modificar.
     * @param nombre Nuevo nombre del rol.
     */
    public void modificarRol(Rol rol, String nombre) {
        rol.setNombre(nombre);
        controlPersis.modificarRol(rol);
    }

    /**
     * Elimina un rol por su ID.
     *
     * @param id_rol Identificador único del rol.
     */
    public void borrarRol(int id_rol) {
        controlPersis.borrarRol(id_rol);
    }
    
     // ------------------- CRUD Cita -------------------

       /**
     * Guarda una nueva cita en el sistema.
     * <p>
     * Este método construye un objeto {@link Cita} a partir del ID de la mascota,
     * la fecha/hora de la cita y la lista de servicios seleccionados. Luego delega
     * la persistencia del objeto a la capa de control de persistencia.
     *
     * @param idMascota  Identificador de la mascota asociada a la cita.
     * @param fechaHora  Fecha y hora programada para la cita.
     * @param servicio   Lista de servicios que se aplicarán en la cita.
     */
    public void guardarCita(int idMascota, LocalDateTime fechaHora, List<Servicios> servicio) {
        Mascotas mascota = controlPersis.traerMascota(idMascota);

        Cita cita = new Cita();
        cita.setFechaHora(fechaHora);
        cita.setMascota(mascota);
        cita.setServicio(servicio);

        controlPersis.guardarCita(cita);
    }

    /**
     * Obtiene todas las citas registradas en el sistema.
     *
     * @return Lista completa de citas almacenadas.
     */
    public List<Cita> traerCitas() {
        return controlPersis.traerCitas();
    }

    /**
     * Modifica una cita existente.
     * <p>
     * El método actualiza la cita enviada como parámetro y delega la operación
     * a la capa de persistencia.
     *
     * @param cita Objeto {@link Cita} con los datos actualizados.
     * @throws Exception Si ocurre un error durante la actualización.
     */
    public void modificarCita(Cita cita) throws Exception {
        controlPersis.modificarCita(cita);
    }

    /**
     * Busca una cita específica según su ID.
     *
     * @param id Identificador único de la cita.
     * @return La cita correspondiente, o {@code null} si no existe.
     */
    public Cita buscarCitaPorId(int id) {
        return controlPersis.buscarCitaPorId(id);
    }

    /**
     * Elimina una cita del sistema según su ID.
     *
     * @param id Identificador de la cita a eliminar.
     * @throws Exception Si la eliminación falla o la cita no existe.
     */
    public void eliminarCita(int id) throws Exception {
        controlPersis.eliminarCita(id);
    }

    // ------------------- Servicios -------------------

    /**
     * Obtiene todos los servicios disponibles en el sistema.
     *
     * @return Lista de servicios registrados.
     */
    public List<Servicios> traerServicios() {
        return controlPersis.traerServicios();
    }


} // fin clase Controladora
