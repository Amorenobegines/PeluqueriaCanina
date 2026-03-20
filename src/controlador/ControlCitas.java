package controlador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.CitaJpaController;
import persistencia.MascotasJpaController;
import persistencia.ServiciosJpaController;
import logica.Cita;
import logica.Mascotas;
import logica.Servicios;

public class ControlCitas {

    private final CitaJpaController citaJpa = new CitaJpaController();
    private final MascotasJpaController mascotaJpa = new MascotasJpaController();
    private final ServiciosJpaController serviciosJpa = new ServiciosJpaController();

    // ============================
    //   MÉTODOS DE CONSULTA
    // ============================
    public List<Cita> traerCitas() {
        return citaJpa.findCitaEntities();
    }

    public Cita traerCita(int id) {
        return citaJpa.findCita(id);
    }

    public List<Mascotas> traerMascotas() {
        return mascotaJpa.findMascotasEntities();
    }

    public List<Servicios> traerServicios() {
        return serviciosJpa.findServiciosEntities();
    }

    public List<Cita> buscarPorFecha(LocalDate fecha) {
        return citaJpa.findCitasByFecha(fecha);
    }

    // ============================
    //   MÉTODOS DE TABLA
    // ============================
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

    // ============================
    //   CREAR CITA
    // ============================
    public void guardarCita(int idMascota, LocalDateTime fecha, List<Servicios> servicios) {
        Mascotas mascota = mascotaJpa.findMascotas(idMascota);

        Cita cita = new Cita();
        cita.setMascota(mascota);
        cita.setFechaHora(fecha);
        cita.setServicio(servicios);

        citaJpa.create(cita);
    }

    // ============================
    //   EDITAR CITA
    // ============================
    public void editarCita(int idCita, Mascotas mascota, LocalDateTime fecha, List<Servicios> servicios) throws Exception {
        Cita cita = citaJpa.findCita(idCita);

        cita.setMascota(mascota);
        cita.setFechaHora(fecha);
        cita.setServicio(servicios);

        citaJpa.edit(cita);
    }

    // ============================
    //   ELIMINAR CITA
    // ============================
    public void eliminarCita(int idCita) throws Exception {
        citaJpa.destroy(idCita);
    }

    // ============================
    //   UTILIDADES
    // ============================
    public LocalDateTime convertirFecha(Date fecha) {
        return fecha.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public String convertirServiciosTexto(Cita c) {
        if (c.getServicio() == null || c.getServicio().isEmpty()) {
            return "Sin servicios";
        }

        return c.getServicio().stream()
                .map(s -> s.getTipoServicios() + " (" + s.getPrecio() + "€)")
                .collect(Collectors.joining(", "));
    }

}
