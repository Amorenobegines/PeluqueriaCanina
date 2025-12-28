package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Representa un servicio disponible en el sistema.
 * <p>
 * Cada servicio tiene un tipo, un precio y puede estar asociado a múltiples
 * citas y mascotas mediante relaciones ManyToMany.
 */
@Entity
@Table(name = "servicios")
public class Servicios implements Serializable {

    /**
     * Identificador único del servicio. Se genera automáticamente mediante la
     * estrategia IDENTITY.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_servicio;

    /**
     * Nombre o tipo del servicio. Ejemplo: "Baño", "Corte de pelo",
     * "Vacunación".
     */
    private String tipoServicios;

    /**
     * Precio del servicio en la moneda correspondiente.
     */
    private double precio;

    /**
     * Lista de citas asociadas a este servicio. Representa la relación
     * Many-To-Many mapeada en {@link Cita#servicios}.
     */
    @ManyToMany(mappedBy = "servicios")
    private List<Cita> citas = new ArrayList<>();

    /**
     * Lista de mascotas asociadas a este servicio. Representa la relación
     * Many-To-Many mapeada en {@link Mascotas#servicios}.
     */
    @ManyToMany(mappedBy = "servicios")
    private List<Mascotas> mascotas = new ArrayList<>();

    /**
     * Constructor vacío requerido por JPA.
     */
    public Servicios() {
    }

    /**
     * Constructor que permite crear un servicio con tipo y precio.
     *
     * @param tipoServicios Nombre o tipo del servicio.
     * @param precio Precio del servicio.
     */
    public Servicios(String tipoServicios, double precio) {
        this.tipoServicios = tipoServicios;
        this.precio = precio;
    }

    // Getter & Setter
    
   /**
     * Obtiene el ID único del servicio.
     *
     * @return Identificador del servicio.
     */
    public int getId_servicio() {
        return id_servicio;
    }

    /**
     * Establece el ID del servicio.
     *
     * @param id_servicio Nuevo identificador del servicio.
     */
    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    /**
     * Obtiene el nombre o tipo del servicio.
     *
     * @return Nombre del servicio.
     */
    public String getTipoServicios() {
        return tipoServicios;
    }

    /**
     * Establece el nombre o tipo del servicio.
     *
     * @param tipoServicios Nuevo nombre del servicio.
     */
    public void setTipoServicios(String tipoServicios) {
        this.tipoServicios = tipoServicios;
    }

    /**
     * Obtiene el precio del servicio.
     *
     * @return Precio del servicio.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del servicio.
     *
     * @param precio Nuevo precio del servicio.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la lista de mascotas asociadas a este servicio.
     *
     * @return Lista de {@link Mascotas} relacionadas.
     */
    public List<Mascotas> getMascotas() {
        return mascotas;
    }

    /**
     * Establece la lista de mascotas asociadas a este servicio.
     *
     * @param mascotas Lista de mascotas a asociar.
     */
    public void setMascotas(List<Mascotas> mascotas) {
        this.mascotas = mascotas;
    }

    /**
     * Obtiene la lista de citas que incluyen este servicio.
     *
     * @return Lista de {@link Cita} relacionadas.
     */
    public List<Cita> getCitas() {
        return citas;
    }

    /**
     * Establece la lista de citas que incluyen este servicio.
     *
     * @param citas Lista de citas a asociar.
     */
    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    /**
     * Devuelve una representación en texto del servicio.
     * <p>
     * Esto facilita mostrar el nombre del servicio en componentes gráficos
     * como listas, tablas o combos.
     *
     * @return Nombre o tipo del servicio.
     */
    @Override
    public String toString() {
        return tipoServicios;
    }
} // Fin class Servicios