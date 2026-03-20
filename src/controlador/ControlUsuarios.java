package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import logica.Rol;
import logica.Usuarios;
import persistencia.RolJpaController;
import persistencia.UsuariosJpaController;

public class ControlUsuarios {

    private final UsuariosJpaController usuarioJpa = new UsuariosJpaController();
    private final RolJpaController rolJpa = new RolJpaController();

    // ============================
    //   CONSULTAS
    // ============================
    public List<Usuarios> traerUsuarios() {
        return usuarioJpa.findUsuariosEntities();
    }

    public Usuarios traerUsuario(int id) {
        return usuarioJpa.findUsuarios(id);
    }

    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
    }

    // ============================
    //   VALIDACIONES
    // ============================
    public boolean emailValido(String email) {
        String patron = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(patron, email);
    }

    public boolean emailDuplicado(String email, int idActual) {
        for (Usuarios u : traerUsuarios()) {
            if (u.getEmail().equalsIgnoreCase(email) && u.getId() != idActual) {
                return true;
            }
        }
        return false;
    }

    // ============================
    //   LOGIN
    // ============================
    /**
     * Busca un usuario por email y contraseña.
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
     * Devuelve solo el rol del usuario si las credenciales son correctas.
     */
    public String iniciarSesionYObtenerRol(String email, String pass) {
        Usuarios usuario = iniciarSesion(email, pass);

        if (usuario == null) {
            return null;
        }

        return usuario.getTipo_rol().getNombre().trim().toLowerCase();
    }

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

    // ============================
    //   GUARDAR USUARIO
    // ============================
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

    // ============================
    //   MODIFICAR USUARIO
    // ============================
    public void modificarUsuario(int id, String nombre, String apellidos, String email, String rolNombre) throws Exception {

        Usuarios usuario = traerUsuario(id);

        usuario.setNombre(nombre);
        usuario.setApellidos(apellidos);
        usuario.setEmail(email);

        Rol rol = rolJpa.findRolByNombre(rolNombre);
        usuario.setTipo_rol(rol);

        usuarioJpa.edit(usuario);
    }

    // ============================
    //   ELIMINAR
    // ============================
    public void eliminarUsuario(int id) {
        try {
            usuarioJpa.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar usuario: " + e.getMessage());
        }
    }

    // ============================
    //   FILTRAR POR ROL
    // ============================
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
