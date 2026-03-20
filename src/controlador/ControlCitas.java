package controlador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import persistencia.CitaJpaController;
import persistencia.MascotasJpaController;
import persistencia.ServiciosJpaController;
import logica.Cita;
import logica.Mascotas;
import logica.Servicios;

/**
 * Controlador encargado de gestionar todas las operaciones relacionadas con las
 * citas dentro del sistema.
 * <p>
 * Esta clase forma parte de la capa de lógica del patrón MVC y actúa como
 * intermediaria entre la interfaz gráfica y la capa de persistencia. Su
 * responsabilidad es coordinar la creación, edición, eliminación y consulta de
 * citas, delegando el acceso a la base de datos en los controladores JPA:
 * {@code CitaJpaController}, {@code MascotasJpaController} y
 * {@code ServiciosJpaController}.
 * </p>
 *
 * <p>
 * Entre las funcionalidades que proporciona se incluyen:
 * </p>
 * <ul>
 * <li>Obtener listas completas de citas, mascotas y servicios.</li>
 * <li>Buscar citas por fecha.</li>
 * <li>Construir los datos necesarios para mostrar citas en tablas.</li>
 * <li>Crear nuevas citas asociando mascota, fecha y servicios.</li>
 * <li>Editar citas existentes.</li>
 * <li>Eliminar citas de la base de datos.</li>
 * <li>Convertir fechas y listas de servicios a formatos adecuados para la
 * vista.</li>
 * </ul>
 *
 * <p>
 * Esta clase encapsula toda la lógica de negocio relacionada con las citas,
 * garantizando que la vista permanezca limpia y sin lógica de persistencia.
 * </p>
 */
public class ControlCitas {

    private final CitaJpaController citaJpa = new CitaJpaController();
    private final MascotasJpaController mascotaJpa = new MascotasJpaController();
    private final ServiciosJpaController serviciosJpa = new ServiciosJpaController();

    /**
     * Obtiene la lista completa de citas registradas en la base de datos.
     *
     * @return Lista de objetos {@code Cita}.
     */
    public List<Cita> traerCitas() {
        return citaJpa.findCitaEntities();
    }

    /**
     * Recupera una cita específica según su identificador.
     *
     * @param id Identificador único de la cita.
     * @return Objeto {@code Cita} correspondiente, o {@code null} si no existe.
     */
    public Cita traerCita(int id) {
        return citaJpa.findCita(id);
    }

    /**
     * Obtiene todas las mascotas registradas en el sistema.
     *
     * @return Lista de objetos {@code Mascotas}.
     */
    public List<Mascotas> traerMascotas() {
        return mascotaJpa.findMascotasEntities();
    }

    /**
     * Obtiene todos los servicios disponibles en el sistema.
     *
     * @return Lista de objetos {@code Servicios}.
     */
    public List<Servicios> traerServicios() {
        return serviciosJpa.findServiciosEntities();
    }

    /**
     * Busca todas las citas que coinciden con una fecha específica.
     *
     * @param fecha Fecha a consultar.
     * @return Lista de citas programadas para esa fecha.
     */
    public List<Cita> buscarPorFecha(LocalDate fecha) {
        return citaJpa.findCitasByFecha(fecha);
    }

    /**
     * Construye una lista de filas listas para ser usadas en una tabla de
     * citas.
     * <p>
     * Cada fila contiene: ID, fecha/hora, nombre de la mascota y los servicios
     * asociados en formato de texto.
     * </p>
     *
     * @return Lista de arreglos de objetos representando filas de tabla.
     */
    public List<Object[]> obtenerDatosTabla() {
        List<Object[]> filas = new ArrayList<>();

        for (Cita c : traerCitas()) {

            String serviciosTexto = c.getServicio().isEmpty()
                    ? "Sin servicios"
                    : c.getServicio().stream()
                            .map(s -> s.getTipoServicios() + " (" + s.getPrecio() + "€)")
                            .collect(Collectors.joining(", "));

            filas.add(new Object[]{
                c.getId(),
                c.getFechaHora(),
                c.getMascota().getNombreMas(),
                serviciosTexto
            });
        }
        return filas;
    }

    /**
     * Crea y guarda una nueva cita en la base de datos.
     *
     * @param idMascota ID de la mascota asociada.
     * @param fecha Fecha y hora de la cita.
     * @param servicios Lista de servicios seleccionados.
     */
    public void guardarCita(int idMascota, LocalDateTime fecha, List<Servicios> servicios) {
        Mascotas mascota = mascotaJpa.findMascotas(idMascota);

        Cita cita = new Cita();
        cita.setMascota(mascota);
        cita.setFechaHora(fecha);
        cita.setServicio(servicios);

        citaJpa.create(cita);
    }

    /**
     * Modifica los datos de una cita existente.
     *
     * @param idCita ID de la cita a editar.
     * @param mascota Nueva mascota asociada.
     * @param fecha Nueva fecha y hora.
     * @param servicios Lista actualizada de servicios.
     * @throws Exception Si ocurre un error al actualizar la cita.
     */
    public void editarCita(int idCita, Mascotas mascota, LocalDateTime fecha, List<Servicios> servicios) throws Exception {
        Cita cita = citaJpa.findCita(idCita);

        cita.setMascota(mascota);
        cita.setFechaHora(fecha);
        cita.setServicio(servicios);

        citaJpa.edit(cita);
    }

    /**
     * Elimina una cita de la base de datos según su ID.
     *
     * @param idCita Identificador de la cita a eliminar.
     * @throws Exception Si la cita no existe o no puede eliminarse.
     */
    public void eliminarCita(int idCita) throws Exception {
        citaJpa.destroy(idCita);
    }

    /**
     * Convierte un objeto {@code java.util.Date} a {@code LocalDateTime}.
     *
     * @param fecha Fecha a convertir.
     * @return Fecha convertida a {@code LocalDateTime}.
     */
    public LocalDateTime convertirFecha(Date fecha) {
        return fecha.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    /**
     * Convierte la lista de servicios de una cita en un texto legible.
     * <p>
     * El formato generado es: "Servicio (precio€), Servicio2 (precio€)..."
     * </p>
     *
     * @param c Cita de la cual obtener los servicios.
     * @return Cadena con los servicios formateados o "Sin servicios".
     */
    public String convertirServiciosTexto(Cita c) {
        if (c.getServicio() == null || c.getServicio().isEmpty()) {
            return "Sin servicios";
        }

        return c.getServicio().stream()
                .map(s -> s.getTipoServicios() + " (" + s.getPrecio() + "€)")
                .collect(Collectors.joining(", "));
    }

}
