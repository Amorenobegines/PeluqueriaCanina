package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany; 
import javax.persistence.Table;

/**
 * Entidad JPA que representa una mascota registrada en la peluquería canina.
 *
 * Cada mascota tiene atributos como nombre, raza, color, alergias, atención
 * especial y observaciones, además de estar asociada a un dueño mediante una
 * relación uno a uno.
 *
 * Esta clase se mapea a una tabla en la base de datos y utiliza generación
 * Identity para el identificador único del cliente.
 *
 * @author Alicia
 */
@Entity
@Table(name = "mascotas")
public class Mascotas implements Serializable {
 
    /**
     * Identificador único del cliente (mascota). Se genera automáticamente de
     * forma secuencial.
     */
    @Id  // num_cliente
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int num_cliente;

    private String nombreMas;
    private String raza;
    private String color;
    private String alergico;
    private String atencion_especial;
    private String observaciones;

    /**
     * Relación uno a uno con la entidad Duenio. Representa el dueño asociado a
     * esta mascota.
     */
    @ManyToOne
    @JoinColumn(name = "UNDUENIO_ID_DUENIO")  // FK hacia la tabla duenio
    private Duenio unDuenio;
    
    @ManyToMany
    @JoinTable(
        name = "mascota_servicios",
        joinColumns = @JoinColumn(name = "id_mascota"),
        inverseJoinColumns = @JoinColumn(name = "id_servicio")
    )
    private List<Servicios> servicios = new ArrayList<>();

    // Relación con citas
    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL)
    private List<Cita> citas;
  

    /**
     * Constructor por defecto requerido por JPA.
     */
    public Mascotas() {
    }

    /**
     * Constructor completo para inicializar todos los atributos de la mascota.
     *
     * @param num_cliente Identificador único del cliente.
     * @param nombre Nombre de la mascota.
     * @param raza Raza de la mascota.
     * @param color Color de la mascota.
     * @param alergico Información sobre alergias.
     * @param atencion_especial Necesidades especiales de atención.
     * @param observaciones Observaciones adicionales.
     * @param unDuenio Dueño asociado a la mascota.
     */
    public Mascotas(int num_cliente, String nombre, String raza, String color, String alergico, String atencion_especial, String observaciones, Duenio unDuenio) {
        this.num_cliente = num_cliente;
        this.nombreMas = nombre;
        this.raza = raza;
        this.color = color;
        this.alergico = alergico;
        this.atencion_especial = atencion_especial;
        this.observaciones = observaciones;
        this.unDuenio = unDuenio;
    }

    /**
     * Obtiene el número de cliente asignado a la mascota.
     *
     * @return Número de cliente (ID único).
     */
    public int getNum_cliente() {
        return num_cliente;
    }

    /**
     * Establece el número de cliente para la mascota.
     *
     * @param id_cliente Nuevo número de cliente.
     */
    public void setNum_cliente(int id_cliente) {
        this.num_cliente = id_cliente;
    }

    /**
     * Obtiene el nombre de la mascota.
     *
     * @return Nombre de la mascota.
     */
    public String getNombreMas() {
        return nombreMas;
    }

    /**
     * Establece el nombre de la mascota.
     *
     * @param nombreMas Nuevo nombre de la mascota.
     */
    public void setNombreMas(String nombreMas) {
        this.nombreMas = nombreMas;
    }

    /**
     * Obtiene la raza de la mascota.
     *
     * @return Raza de la mascota.
     */
    public String getRaza() {
        return raza;
    }

    /**
     * Establece la raza de la mascota.
     *
     * @param raza Nueva raza.
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * Obtiene el color de la mascota.
     *
     * @return Color de la mascota.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color de la mascota.
     *
     * @param color Nuevo color.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Indica si la mascota es alérgica.
     *
     * @return Información sobre alergias.
     */
    public String getAlergico() {
        return alergico;
    }

    /**
     * Establece la información sobre alergias de la mascota.
     *
     * @param alergico Nueva información de alergia.
     */
    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    /**
     * Obtiene las necesidades especiales de atención de la mascota.
     *
     * @return Detalles de atención especial.
     */
    public String getAtencion_especial() {
        return atencion_especial;
    }

    /**
     * Establece las necesidades especiales de atención de la mascota.
     *
     * @param atencion_especial Nueva atención especial.
     */
    public void setAtencion_especial(String atencion_especial) {
        this.atencion_especial = atencion_especial;
    }

    /**
     * Obtiene las observaciones adicionales sobre la mascota.
     *
     * @return Observaciones.
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Establece observaciones adicionales sobre la mascota.
     *
     * @param observaciones Nuevas observaciones.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Obtiene el dueño asociado a la mascota.
     *
     * @return Objeto Duenio vinculado.
     */
    public Duenio getUnDuenio() {
        return unDuenio;
    }

    /**
     * Establece el dueño asociado a la mascota.
     *
     * @param unDuenio Nuevo objeto Duenio.
     */
    public void setUnDuenio(Duenio unDuenio) {
        this.unDuenio = unDuenio;
    }

        /**
     * Obtiene la lista de servicios asociados a esta mascota.
     *
     * @return Lista de objetos {@link Servicios} correspondientes a los servicios asignados.
     */
    public List<Servicios> getServicios() {
        return servicios;
    }

    /**
     * Establece la lista de servicios asociados a esta mascota.
     *
     * @param servicios Lista de servicios que se asignarán a la mascota.
     */
    public void setServicios(List<Servicios> servicios) {
        this.servicios = servicios;
    }

    /**
     * Obtiene la lista de citas registradas para esta mascota.
     *
     * @return Lista de objetos {@link Cita} correspondientes a las citas de la mascota.
     */
    public List<Cita> getCitas() {
        return citas;
    }

    /**
     * Establece la lista de citas asociadas a esta mascota.
     *
     * @param citas Lista de citas que se asignarán a la mascota.
     */
    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    /**
     * Devuelve el nombre de la mascota como representación en texto.
     * <p>
     * Esto facilita mostrar la mascota correctamente en componentes visuales
     * como listas, tablas o combos.
     *
     * @return El nombre de la mascota.
     */
    @Override
    public String toString() {
        return nombreMas;
    }

}
