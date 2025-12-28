package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa a un usuario del sistema de gestión de la peluquería
 * canina.
 *
 * Cada usuario tiene un identificador único, nombre, apellidos, correo
 * electrónico, nivel de acceso (rol) y una contraseña para autenticación.
 *
 * Esta clase puede ser utilizada para gestionar el acceso al sistema y
 * controlar los permisos según el tipo de usuario.
 *
 * @author Alicia
 */
@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    // Atributo
    /**
     * Identificador único del usuario.
     */
    @Id  // os del usuario
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // se genera un numero en forma secuencial
    private int id;

    private String nombre;
    // @Column(name = "apellido")
    private String apellidos;
    private String email;
    //  private String tipoNivel;
    private String pass;

    @ManyToOne   // varios usuarios pueden compartir el mismo rol
    @JoinColumn(name = "id_rol")
    private Rol tipo_rol;

    /**
     * Constructor por defecto requerido por frameworks de persistencia.
     */
    public Usuarios() {
    }

    /**
     * Constructor completo para inicializar todos los atributos del usuario.
     *
     * @param nombre Nombre del usuario.
     * @param apellidos Apellidos del usuario.
     * @param email Correo electrónico del usuario.
     * @param tipo_rol Rol del usuario
     * @param pass Contraseña del usuario.
     */
    public Usuarios(String nombre, String apellidos, String email, String pass, Rol tipo_rol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.pass = pass;
        this.tipo_rol = tipo_rol;
    }

    // Métodos getter y setter
    /**
     * Obtiene el id del usuario.
     *
     * @return id del usuario
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param id Identificador único del usuario.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre Nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del usuario.
     *
     * @return Apellidos del usuario.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del usuario.
     *
     * @param apellidos Apellidos del usuario.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return Email del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email Email del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return Contraseña del usuario.
     */
    public String getPass() {
        return pass;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param pass Contraseña del usuario.
     */
    public void setPass(String pass) {
        this.pass = pass;

    }

    /**
     * Obtiene el rol asociado a este usuario.
     *
     * @return Objeto {@link Rol} que representa el tipo de rol del usuario.
     */
    public Rol getTipo_rol() {
        return tipo_rol;
    }

    /**
     * Establece el rol de este usuario.
     *
     * @param tipo_rol Objeto {@link Rol} que representa el nuevo tipo de rol
     * del usuario.
     */
    public void setTipo_rol(Rol tipo_rol) {
        this.tipo_rol = tipo_rol;
    }

} // Fin class Usuarios
