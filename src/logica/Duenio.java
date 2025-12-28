package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entidad JPA que representa al dueño de una mascota en el sistema de
 * peluquería canina.
 *
 * Cada dueño tiene un identificador único, nombre y número de teléfono. Esta
 * clase se mapea a una tabla en la base de datos y puede estar relacionada con
 * una mascota mediante una asociación uno a uno.
 *
 * @author Alicia
 */
@Entity
public class Duenio implements Serializable {

    
    /**
     * Identificador único del dueño. 
     */
    @Id  // id_duenio
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id_duenio;

      /**
     * Nombre del dueño.
     * Representa el nombre completo de la persona responsable de una o más mascotas.
     */
    private String nombre;

    /**
     * Teléfono de contacto del dueño.
     * Se utiliza para comunicación y notificaciones relacionadas con las mascotas o citas.
     */
    private String telefono;

    /**
     * Lista de mascotas asociadas a este dueño.
     * <p>
     * Relación OneToMany: un dueño puede tener múltiples mascotas.
     * Está mapeada por el atributo "unDuenio" dentro de la entidad {@link Mascotas}.
     * <p>
     * El uso de {@link CascadeType#ALL} permite que las operaciones realizadas sobre
     * el dueño (guardar, actualizar, eliminar) se propaguen automáticamente a sus mascotas.
     */
    @OneToMany(mappedBy = "unDuenio", cascade = CascadeType.ALL)
    private List<Mascotas> mascotas;

    /**
     * Constructor por defecto requerido por JPA.
     */
    public Duenio() {
    }

    /**
     * Constructor completo para inicializar todos los atributos del dueño.
     *
     * @param id_duenio Identificador único del dueño.
     * @param nombre Nombre del dueño.
     * @param telefono Número de teléfono del dueño.
     */
    public Duenio(int id_duenio, String nombre, String telefono) {
        this.id_duenio = id_duenio;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Metodos getter and setter
    /**
     * Devuelve el identificador único del dueño.
     *
     * @return ID del dueño.
     */
    public int getId_duenio() {
        return id_duenio;
    }

    /**
     * Establece el identificador único del dueño.
     *
     * @param id_duenio Nuevo ID del dueño.
     */
    public void setId_duenio(int id_duenio) {
        this.id_duenio = id_duenio;
    }

    /**
     * Devuelve el nombre del dueño.
     *
     * @return Nombre del dueño.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del dueño.
     *
     * @param nombre Nuevo nombre del dueño.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el número de teléfono del dueño.
     *
     * @return Teléfono del dueño.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del dueño.
     *
     * @param telefono Nuevo número de teléfono.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
