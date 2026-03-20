package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import logica.Duenio;
import logica.Mascotas;
import logica.Servicios;
import persistencia.DuenioJpaController;
import persistencia.MascotasJpaController;

public class ControlMascotas {

    private final MascotasJpaController mascotaJpa = new MascotasJpaController();
    private final DuenioJpaController duenioJpa = new DuenioJpaController();

    // ============================================================
    //   GUARDAR MASCOTA + DUEÑO
    // ============================================================
    public void guardarMascota(String nombreMasco, String raza, String color, String observaciones,
                               String alergia, String atenEsp, String nombreDuenio, String telefono) {

        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setTelefono(telefono);

        Mascotas masco = new Mascotas();
        masco.setNombreMas(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergia);
        masco.setAtencion_especial(atenEsp);
        masco.setUnDuenio(duenio);

        duenioJpa.create(duenio);
        mascotaJpa.create(masco);
    }

    // ============================================================
    //   LISTAR TODAS LAS MASCOTAS
    // ============================================================
    public List<Mascotas> traerMascotas() {
        return mascotaJpa.findMascotasEntities();
    }

    // ============================================================
    //   TRAER UNA MASCOTA POR ID
    // ============================================================
    public Mascotas traerMascota(int id) {
        return mascotaJpa.findMascotas(id);
    }

    // ============================================================
    //   BORRAR MASCOTA
    // ============================================================
    public void borrarMascota(int id) {
        try {
            mascotaJpa.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ============================================================
    //   MODIFICAR MASCOTA + DUEÑO
    // ============================================================
    public void modificarMascota(Mascotas masco, String nombreMasco, String raza, String color,
                                 String observaciones, String alergia, String atenEsp,
                                 String nombreDuenio, String telefono) {

        masco.setNombreMas(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergia);
        masco.setAtencion_especial(atenEsp);

        try {
            mascotaJpa.edit(masco);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Duenio duenio = duenioJpa.findDuenio(masco.getUnDuenio().getId_duenio());
        duenio.setNombre(nombreDuenio);
        duenio.setTelefono(telefono);

        try {
            duenioJpa.edit(duenio);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ============================================================
    //   BUSCAR POR NOMBRE DE DUEÑO
    // ============================================================
    public List<Mascotas> buscarPorNombreDuenio(String nombre) {
        return mascotaJpa.findMascotasByNombreDueno(nombre);
    }

    // ============================================================
    //   CONVERTIR SERVICIOS A TEXTO
    // ============================================================
    public String serviciosToString(Mascotas m) {
        if (m.getServicios() == null || m.getServicios().isEmpty()) {
            return "Sin servicios";
        }

        return m.getServicios().stream()
                .map(s -> s.getTipoServicios() + " (" + s.getPrecio() + "€)")
                .collect(Collectors.joining(", "));
    }

    // ============================================================
    //   GENERAR FILAS PARA LA TABLA
    // ============================================================
    public List<Object[]> obtenerFilasTabla(List<Mascotas> lista) {
        List<Object[]> filas = new ArrayList<>();

        for (Mascotas m : lista) {
            filas.add(new Object[]{
                m.getNum_cliente(),
                m.getNombreMas(),
                m.getRaza(),
                m.getColor(),
                m.getAlergico(),
                m.getAtencion_especial(),
                m.getUnDuenio().getNombre(),
                m.getUnDuenio().getTelefono(),
                m.getObservaciones(),
                serviciosToString(m)
            });
        }
        return filas;
    }
}
