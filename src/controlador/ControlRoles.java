package controlador;

import java.util.List;
import logica.Rol;
import persistencia.RolJpaController;

/**
 *
 * @author Alicia
 */
public class ControlRoles {

    private final RolJpaController rolJpa = new RolJpaController();

    /**
     * Guarda un nuevo rol en la base de datos.
     *
     * @param nombre Nombre del rol.
     */
    public void guardarRol(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del rol no puede estar vacío.");
        }

        // Validar duplicado
        if (rolJpa.findRolByNombre(nombre) != null) {
            throw new IllegalArgumentException("El rol '" + nombre + "' ya existe.");
        }

        Rol rol = new Rol(nombre.trim());
        rolJpa.create(rol);
    }

    /**
     * Recupera la lista completa de roles registrados.
     *
     * @return Lista de objetos Rol.
     */
    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
    }

    /**
     * Recupera un rol específico por su ID.
     *
     * @param id_rol Identificador único del rol.
     * @return Objeto Rol correspondiente.
     */
    public Rol traerRol(int id_rol) {
        return rolJpa.findRol(id_rol);
    }

    /**
     * Modifica los datos de un rol existente.
     *
     * @param idRol ID del rol a modificar.
     * @param nombre Nuevo nombre del rol.
     */
    public void modificarRol(int idRol, String nombre) throws Exception {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del rol no puede estar vacío.");
        }

        Rol rol = rolJpa.findRol(idRol);
        if (rol == null) {
            throw new IllegalArgumentException("El rol no existe.");
        }

        // Validar duplicado
        Rol existente = rolJpa.findRolByNombre(nombre);
        if (existente != null && existente.getId_rol() != idRol) {
            throw new IllegalArgumentException("Ya existe un rol con ese nombre.");
        }

        rol.setNombre(nombre.trim());
        rolJpa.edit(rol);
    }

    /**
     * Elimina un rol por su ID.
     *
     * @param id_rol Identificador único del rol.
     */
    public void borrarRol(int id_rol) {
        try {
            rolJpa.destroy(id_rol);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el rol: " + e.getMessage());
        }
    }

}
