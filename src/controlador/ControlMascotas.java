package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import logica.Duenio;
import logica.Mascotas;
import persistencia.DuenioJpaController;
import persistencia.MascotasJpaController;

/**
 * Controlador encargado de gestionar todas las operaciones relacionadas con las
 * mascotas dentro del sistema.
 * <p>
 * Esta clase forma parte de la capa de lógica del patrón MVC y actúa como
 * intermediaria entre la interfaz gráfica y la capa de persistencia. Su
 * responsabilidad principal es coordinar el alta, baja, modificación y consulta
 * de mascotas, así como la gestión de los datos de sus dueños asociados.
 * </p>
 *
 * <p>
 * Entre las funcionalidades que proporciona se incluyen:
 * </p>
 * <ul>
 * <li>Crear una nueva mascota junto con su dueño.</li>
 * <li>Listar todas las mascotas registradas.</li>
 * <li>Buscar mascotas por ID o por nombre de dueño.</li>
 * <li>Modificar los datos de una mascota y de su dueño.</li>
 * <li>Eliminar mascotas de la base de datos.</li>
 * <li>Generar estructuras de datos listas para ser mostradas en tablas.</li>
 * <li>Formatear los servicios asociados a una mascota en texto legible.</li>
 * </ul>
 *
 * <p>
 * De este modo, {@code ControlMascotas} encapsula la lógica de negocio
 * relacionada con las mascotas, manteniendo la vista libre de detalles de
 * persistencia y facilitando el mantenimiento del código.
 * </p>
 */
public class ControlMascotas {

    private final MascotasJpaController mascotaJpa = new MascotasJpaController();
    private final DuenioJpaController duenioJpa = new DuenioJpaController();

    /**
     * Crea y guarda una nueva mascota junto con su dueño asociado.
     * <p>
     * Este método construye los objetos {@code Duenio} y {@code Mascotas} a
     * partir de los datos proporcionados por la vista. Primero se guarda el
     * dueño en la base de datos y posteriormente la mascota, estableciendo la
     * relación entre ambos.
     * </p>
     *
     * @param nombreMasco Nombre de la mascota.
     * @param raza Raza de la mascota.
     * @param color Color de la mascota.
     * @param observaciones Observaciones adicionales.
     * @param alergia Indica si la mascota es alérgica.
     * @param atenEsp Indica si requiere atención especial.
     * @param nombreDuenio Nombre del dueño.
     * @param telefono Teléfono del dueño.
     */
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

    /**
     * Obtiene la lista completa de mascotas registradas en la base de datos.
     *
     * @return Lista de objetos {@code Mascotas}.
     */
    public List<Mascotas> traerMascotas() {
        return mascotaJpa.findMascotasEntities();
    }

    /**
     * Recupera una mascota específica según su identificador.
     *
     * @param id Identificador único de la mascota.
     * @return Objeto {@code Mascotas} correspondiente, o {@code null} si no
     * existe.
     */
    public Mascotas traerMascota(int id) {
        return mascotaJpa.findMascotas(id);
    }

    /**
     * Elimina una mascota de la base de datos según su ID.
     * <p>
     * Si ocurre un error durante la eliminación, se encapsula en una
     * {@code RuntimeException} para simplificar el manejo desde la vista.
     * </p>
     *
     * @param id Identificador de la mascota a eliminar.
     */
    public void borrarMascota(int id) {
        try {
            mascotaJpa.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Modifica los datos de una mascota y de su dueño asociado.
     * <p>
     * Este método actualiza primero los datos de la mascota y luego los del
     * dueño. Ambos cambios se guardan en la base de datos mediante sus
     * respectivos controladores JPA.
     * </p>
     *
     * @param masco Objeto {@code Mascotas} a modificar.
     * @param nombreMasco Nuevo nombre de la mascota.
     * @param raza Nueva raza.
     * @param color Nuevo color.
     * @param observaciones Nuevas observaciones.
     * @param alergia Nueva condición de alergia.
     * @param atenEsp Nueva atención especial.
     * @param nombreDuenio Nuevo nombre del dueño.
     * @param telefono Nuevo teléfono del dueño.
     */
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

    /**
     * Busca todas las mascotas cuyo dueño coincida con el nombre indicado.
     *
     * @param nombre Nombre del dueño a buscar.
     * @return Lista de mascotas pertenecientes a ese dueño.
     */
    public List<Mascotas> buscarPorNombreDuenio(String nombre) {
        return mascotaJpa.findMascotasByNombreDueno(nombre);
    }

    /**
     * Convierte la lista de servicios asociados a una mascota en un texto
     * legible.
     * <p>
     * El formato generado es: "Servicio (precio€), Servicio2 (precio€)...". Si
     * la mascota no tiene servicios, devuelve "Sin servicios".
     * </p>
     *
     * @param m Mascota de la cual obtener los servicios.
     * @return Cadena con los servicios formateados.
     */
    public String serviciosToString(Mascotas m) {
        if (m.getServicios() == null || m.getServicios().isEmpty()) {
            return "Sin servicios";
        }

        return m.getServicios().stream()
                .map(s -> s.getTipoServicios() + " (" + s.getPrecio() + "€)")
                .collect(Collectors.joining(", "));
    }

    /**
     * Genera una lista de filas listas para ser usadas en una tabla de
     * mascotas.
     * <p>
     * Cada fila contiene: número de cliente, nombre, raza, color, alergias,
     * atención especial, nombre del dueño, teléfono, observaciones y servicios.
     * </p>
     *
     * @param lista Lista de mascotas a convertir en filas.
     * @return Lista de arreglos de objetos representando filas de tabla.
     */
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
