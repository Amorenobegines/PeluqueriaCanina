
package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Representa un rol de usuario en el sistema.
 * <p>
 * Los roles definen el nivel de acceso y las funciones que un usuario puede
 * realizar, como "ADMIN", "RECEPCIONISTA" o "TRABAJADOR".
 * Esta entidad se mapea automáticamente a la base de datos mediante JPA.
 */
@Entity
public class Rol implements Serializable {

     /**
     * Identificador único del rol.
     * Se genera automáticamente mediante la estrategia IDENTITY.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rol;

     /**
     * Nombre del rol.
     * Ejemplos: "ADMIN", "RECEPCIONISTA", "TRABAJADOR".
     */
    private String nombre; //  "ADMIN", "RECEPCIONISTA", "TRABAJADOR"

    /**
     * Constructor vacío requerido por JPA.
     */
    public Rol() {
    }
 
    /**
     * Constructor que permite crear un rol con un nombre específico.
     *
     * @param nombre Nombre del rol a asignar.
     */
    public Rol(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    
     /**
     * Obtiene el ID único del rol.
     *
     * @return Identificador del rol.
     */
    public int getId_rol() {
        return id_rol;
    }

    /**
     * Establece el ID del rol.
     *
     * @param id_rol Nuevo identificador del rol.
     */
    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    /**
     * Obtiene el nombre del rol.
     *
     * @return Nombre del rol.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del rol.
     *
     * @param nombre Nuevo nombre del rol.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
} // Fin class Rol