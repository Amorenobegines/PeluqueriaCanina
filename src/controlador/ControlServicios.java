package controlador;

import java.util.List;
import logica.Servicios;
import persistencia.ServiciosJpaController;

public class ControlServicios {

    private final ServiciosJpaController serviciosJpa = new ServiciosJpaController();

    public List<Servicios> traerServicios() {
        return serviciosJpa.findServiciosEntities();
    }

    public Servicios traerServicio(int id) {
        return serviciosJpa.findServicios(id);
    }

    public void guardarServicio(String tipo, double precio) {
        Servicios s = new Servicios();
        s.setTipoServicios(tipo);
        s.setPrecio(precio);
        serviciosJpa.create(s);
    }

    public void modificarServicio(int id, String tipo, double precio) throws Exception {
        Servicios s = serviciosJpa.findServicios(id);
        s.setTipoServicios(tipo);
        s.setPrecio(precio);
        serviciosJpa.edit(s);
    }

    public void eliminarServicio(int id) {
        try {
            serviciosJpa.destroy(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar servicio", e);
        }
    }
}

