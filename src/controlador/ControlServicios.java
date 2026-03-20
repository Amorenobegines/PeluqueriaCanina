package controlador;

import java.util.List;
import logica.Servicios;
import persistencia.ServiciosJpaController;

/**
 * Controlador encargado de gestionar todas las operaciones relacionadas con los
 * servicios ofrecidos por la peluquería canina.
 * <p>
 * Esta clase forma parte de la capa de lógica del patrón MVC y actúa como
 * intermediaria entre la interfaz gráfica y la capa de persistencia. Su
 * responsabilidad principal es coordinar la creación, modificación, consulta y
 * eliminación de servicios, delegando el acceso a la base de datos en
 * {@code ServiciosJpaController}.
 * </p>
 *
 * <p>
 * Entre las funcionalidades que proporciona se incluyen:
 * </p>
 * <ul>
 * <li>Listar todos los servicios disponibles.</li>
 * <li>Buscar servicios por su identificador.</li>
 * <li>Crear nuevos servicios con su tipo y precio.</li>
 * <li>Modificar servicios existentes.</li>
 * <li>Eliminar servicios de la base de datos.</li>
 * </ul>
 *
 * <p>
 * Esta clase encapsula la lógica de negocio relacionada con los servicios,
 * manteniendo la vista libre de detalles de persistencia y facilitando el
 * mantenimiento del sistema.
 * </p>
 */
public class ControlServicios {

    private final ServiciosJpaController serviciosJpa = new ServiciosJpaController();

    /**
     * Obtiene la lista completa de servicios registrados en la base de datos.
     *
     * @return Lista de objetos {@code Servicios}.
     */
    public List<Servicios> traerServicios() {
        return serviciosJpa.findServiciosEntities();
    }

    /**
     * Recupera un servicio específico según su identificador.
     *
     * @param id Identificador único del servicio.
     * @return Objeto {@code Servicios} correspondiente, o {@code null} si no
     * existe.
     */
    public Servicios traerServicio(int id) {
        return serviciosJpa.findServicios(id);
    }

    /**
     * Crea y guarda un nuevo servicio en la base de datos.
     *
     * @param tipo Nombre o tipo del servicio (por ejemplo, "Baño", "Corte").
     * @param precio Precio asociado al servicio.
     */
    public void guardarServicio(String tipo, double precio) {
        Servicios s = new Servicios();
        s.setTipoServicios(tipo);
        s.setPrecio(precio);
        serviciosJpa.create(s);
    }

    /**
     * Modifica los datos de un servicio existente.
     *
     * @param id Identificador del servicio a modificar.
     * @param tipo Nuevo nombre o tipo del servicio.
     * @param precio Nuevo precio del servicio.
     * @throws Exception Si ocurre un error al actualizar el servicio.
     */
    public void modificarServicio(int id, String tipo, double precio) throws Exception {
        Servicios s = serviciosJpa.findServicios(id);
        s.setTipoServicios(tipo);
        s.setPrecio(precio);
        serviciosJpa.edit(s);
    }

    /**
     * Elimina un servicio de la base de datos según su ID.
     * <p>
     * Si ocurre un error durante la eliminación, se encapsula en una
     * {@code RuntimeException} para simplificar el manejo desde la vista.
     * </p>
     *
     * @param id Identificador del servicio a eliminar.
     */
    public void eliminarServicio(int id) {
        try {
            serviciosJpa.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar servicio", e);
        }
    }

}
