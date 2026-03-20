package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import logica.Rol;
import logica.Usuarios;
import persistencia.RolJpaController;
import persistencia.UsuariosJpaController;

/**
 * Controlador encargado de gestionar todas las operaciones relacionadas con los
 * usuarios del sistema, incluyendo autenticación, validación, asignación de
 * roles y operaciones CRUD.
 * <p>
 * Esta clase forma parte de la capa de lógica del patrón MVC y actúa como
 * intermediaria entre la interfaz gráfica y la capa de persistencia. Su
 * responsabilidad principal es coordinar la creación, modificación, eliminación
 * y consulta de usuarios, delegando el acceso a la base de datos en
 * {@code UsuariosJpaController} y {@code RolJpaController}.
 * </p>
 *
 * <p>
 * Entre las funcionalidades que proporciona se incluyen:
 * </p>
 * <ul>
 * <li>Listar usuarios y roles.</li>
 * <li>Validar formato y duplicidad de correos electrónicos.</li>
 * <li>Autenticar usuarios y obtener su rol.</li>
 * <li>Registrar nuevos usuarios con validaciones integradas.</li>
 * <li>Modificar usuarios existentes.</li>
 * <li>Eliminar usuarios de la base de datos.</li>
 * <li>Filtrar usuarios por rol.</li>
 * </ul>
 *
 * <p>
 * Esta clase encapsula la lógica de negocio relacionada con los usuarios,
 * manteniendo la vista libre de detalles de persistencia y facilitando el
 * mantenimiento del sistema.
 * </p>
 */
public class ControlUsuarios {

    private final UsuariosJpaController usuarioJpa = new UsuariosJpaController();
    private final RolJpaController rolJpa = new RolJpaController();

    /**
     * Obtiene la lista completa de usuarios registrados en la base de datos.
     *
     * @return Lista de objetos {@code Usuarios}.
     */
    public List<Usuarios> traerUsuarios() {
        return usuarioJpa.findUsuariosEntities();
    }

    /**
     * Recupera un usuario específico según su identificador.
     *
     * @param id Identificador único del usuario.
     * @return Objeto {@code Usuarios} correspondiente, o {@code null} si no
     * existe.
     */
    public Usuarios traerUsuario(int id) {
        return usuarioJpa.findUsuarios(id);
    }

    /**
     * Obtiene la lista completa de roles registrados en el sistema.
     *
     * @return Lista de objetos {@code Rol}.
     */
    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
    }

    /**
     * Verifica si un correo electrónico cumple con el formato válido.
     *
     * @param email Correo electrónico a validar.
     * @return {@code true} si el formato es válido, {@code false} en caso
     * contrario.
     */
    public boolean emailValido(String email) {
        String patron = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(patron, email);
    }

    /**
     * Verifica si un correo electrónico ya está registrado en otro usuario.
     *
     * @param email Correo electrónico a comprobar.
     * @param idActual ID del usuario actual (para evitar conflicto al
     * modificar).
     * @return {@code true} si el email ya existe en otro usuario, {@code false}
     * si no.
     */
    public boolean emailDuplicado(String email, int idActual) {
        for (Usuarios u : traerUsuarios()) {
            if (u.getEmail().equalsIgnoreCase(email) && u.getId() != idActual) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca un usuario por email y contraseña para iniciar sesión.
     *
     * @param email Correo electrónico ingresado.
     * @param pass Contraseña ingresada.
     * @return El usuario autenticado o {@code null} si las credenciales no
     * coinciden.
     */
    public Usuarios iniciarSesion(String email, String pass) {
        for (Usuarios u : traerUsuarios()) {
            if (u.getEmail().equalsIgnoreCase(email)
                    && u.getPass().equals(pass)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Autentica un usuario y devuelve únicamente el nombre de su rol.
     *
     * @param email Correo electrónico.
     * @param pass Contraseña.
     * @return Nombre del rol en minúsculas, o {@code null} si las credenciales
     * no son válidas.
     */
    public String iniciarSesionYObtenerRol(String email, String pass) {
        Usuarios usuario = iniciarSesion(email, pass);
        if (usuario == null) {
            return null;
        }
        return usuario.getTipo_rol().getNombre().trim().toLowerCase();
    }

    /**
     * Valida los datos ingresados y registra un nuevo usuario en el sistema.
     * <p>
     * Este método verifica campos vacíos, formato de email, duplicidad y rol
     * válido. Si todo es correcto, delega la creación del usuario al método
     * {@code guardarUsuario}.
     * </p>
     *
     * @param nombre Nombre del usuario.
     * @param apellidos Apellidos del usuario.
     * @param email Correo electrónico.
     * @param pass Contraseña.
     * @param rolNombre Rol asignado.
     * @throws IllegalArgumentException Si alguna validación falla.
     */
    public void registrarUsuario(String nombre, String apellidos, String email, String pass, String rolNombre) {
        // Validar campos vacíos
        if (nombre.isEmpty() || apellidos.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            throw new IllegalArgumentException("Debe completar todos los campos.");
        }

        // Validar email
        if (!emailValido(email)) {
            throw new IllegalArgumentException("El correo electrónico no tiene un formato válido.");
        }

        // Validar duplicado
        if (emailDuplicado(email, -1)) {
            throw new IllegalArgumentException("El correo " + email + " ya está registrado.");
        }

        // Validar rol
        if (rolNombre.equalsIgnoreCase("Seleccionar")) {
            throw new IllegalArgumentException("Debe seleccionar un rol válido.");
        }

        // Guardar usuario
        guardarUsuario(nombre, apellidos, email, pass, rolNombre);
    }

    /**
     * Crea y guarda un nuevo usuario junto con su rol en la base de datos.
     *
     * @param nombre Nombre del usuario.
     * @param apellidos Apellidos del usuario.
     * @param email Correo electrónico.
     * @param pass Contraseña.
     * @param rolNombre Nombre del rol asignado (ej. ADMIN, RECEPCIONISTA).
     */
    public void guardarUsuario(String nombre, String apellidos, String email, String pass, String rolNombre) {

        // Validar email
        if (!emailValido(email)) {
            throw new IllegalArgumentException("El email no tiene un formato válido.");
        }

        // Validar duplicado
        if (emailDuplicado(email, -1)) { // -1 porque es nuevo
            throw new IllegalArgumentException("El email ya está registrado.");
        }

        // Buscar rol
        Rol rol = rolJpa.findRolByNombre(rolNombre);
        if (rol == null) {
            throw new IllegalArgumentException("El rol '" + rolNombre + "' no existe.");
        }

        // Crear usuario
        Usuarios usuario = new Usuarios();
        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setEmail(email);
        usuario.setPass(pass);
        usuario.setTipo_rol(rol);

        // Guardar en BD
        usuarioJpa.create(usuario);
    }

    /**
     * Modifica los datos de un usuario existente.
     *
     * @param id ID del usuario a modificar.
     * @param nombre Nuevo nombre.
     * @param apellidos Nuevos apellidos.
     * @param email Nuevo correo electrónico.
     * @param rolNombre Nuevo rol asignado.
     * @throws Exception Si ocurre un error al actualizar el usuario.
     */
    public void modificarUsuario(int id, String nombre, String apellidos, String email, String rolNombre) throws Exception {
        Usuarios usuario = traerUsuario(id);

        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setEmail(email);

        Rol rol = rolJpa.findRolByNombre(rolNombre);
        usuario.setTipo_rol(rol);

        usuarioJpa.edit(usuario);
    }

    /**
     * Elimina un usuario de la base de datos según su ID.
     *
     * @param id Identificador del usuario a eliminar.
     * @throws RuntimeException Si ocurre un error durante la eliminación.
     */
    public void eliminarUsuario(int id) {
        try {
            usuarioJpa.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar usuario: " + e.getMessage());
        }
    }

    /**
     * Filtra y devuelve todos los usuarios que pertenecen a un rol específico.
     *
     * @param rolNombre Nombre del rol a filtrar.
     * @return Lista de usuarios que poseen ese rol.
     */
    public List<Usuarios> buscarPorRol(String rolNombre) {
        List<Usuarios> filtrados = new ArrayList<>();

        for (Usuarios u : traerUsuarios()) {
            if (u.getTipo_rol() != null
                    && u.getTipo_rol().getNombre().equalsIgnoreCase(rolNombre)) {
                filtrados.add(u);
            }
        }
        return filtrados;
    }
}
