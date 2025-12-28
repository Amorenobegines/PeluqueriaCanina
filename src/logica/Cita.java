package logica;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
/**
 * Representa una cita registrada en el sistema. 
 * Una cita contiene información sobre la fecha y hora en que se realiza,
 * la mascota asociada y la lista de servicios asignados.
 *
 * Esta entidad se mapea a la tabla "cita" en la base de datos.
 */
@Entity
@Table(name = "cita")
public class Cita implements Serializable {

    /**
     * Identificador único de la cita.
     * Se genera automáticamente mediante la estrategia IDENTITY.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Fecha y hora programada de la cita.
     * No puede ser nula.
     */
    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    /**
     * Mascota asociada a la cita.
     * Relación ManyToOne ya que una mascota puede tener varias citas.
     */
    @ManyToOne
    @JoinColumn(name = "id_mascotas", nullable = false)
    private Mascotas mascota;

    /**
     * Lista de servicios asociados a la cita.
     * Relación ManyToMany, mapeada con la tabla intermedia "cita_servicios".
     * Se permiten cascadas de persistencia y merge.
     */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "cita_servicios",
            joinColumns = @JoinColumn(name = "id_cita"),
            inverseJoinColumns = @JoinColumn(name = "id_servicio")
    )
    private List<Servicios> servicios = new ArrayList<>();

    /**
     * Constructor vacío requerido por JPA.
     */
    public Cita() {
    }

    /**
     * Constructor para crear una cita con todos sus datos.
     *
     * @param fechaHora  Fecha y hora de la cita.
     * @param mascota    Mascota relacionada.
     * @param servicios  Lista de servicios asociados.
     */
    public Cita(LocalDateTime fechaHora, Mascotas mascota, List<Servicios> servicios) {
        this.fechaHora = fechaHora;
        this.mascota = mascota;
        this.servicios = servicios;
    }

    /**
     * Obtiene el ID único de la cita.
     *
     * @return Identificador de la cita.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la cita.
     *
     * @param id Nuevo identificador.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha y hora asignada para la cita.
     *
     * @return Fecha y hora de la cita.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la cita.
     *
     * @param fechaHora Nueva fecha y hora.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene la mascota asociada a la cita.
     *
     * @return Mascota correspondiente.
     */
    public Mascotas getMascota() {
        return mascota;
    }

    /**
     * Asocia una mascota a la cita.
     *
     * @param mascota Nueva mascota.
     */
    public void setMascota(Mascotas mascota) {
        this.mascota = mascota;
    }

    /**
     * Obtiene la lista de servicios asignados a la cita.
     *
     * @return Lista de servicios.
     */
    public List<Servicios> getServicio() {
        return servicios;
    }

    /**
     * Establece la lista de servicios de la cita.
     *
     * @param servicios Nueva lista de servicios.
     */
    public void setServicio(List<Servicios> servicios) {
        this.servicios = servicios;
    }
}
