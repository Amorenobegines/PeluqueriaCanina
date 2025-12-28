package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Cita;
import logica.Duenio;
import logica.Mascotas;
import logica.Rol;
import logica.Servicios;
import logica.Usuarios;
import persistencia.exceptions.NonexistentEntityException;

/**
 * Clase encargada de gestionar la capa de persistencia de la aplicación.
 * Centraliza las operaciones CRUD para entidades como Dueños, Mascotas,
 * Servicios, Roles, Usuarios y Citas, utilizando los respectivos controladores
 * JPA.
 *
 * Esta clase actúa como intermediaria entre la lógica de negocio y la base de
 * datos, asegurando la correcta creación, modificación, eliminación y consulta
 * de datos.
 */
public class ControladoraPersistencia {

    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotasJpaController mascoJpa = new MascotasJpaController();
    ServiciosJpaController serviciosJpa = new ServiciosJpaController();

    RolJpaController rolJpa = new RolJpaController();
    UsuariosJpaController usuarioJpa = new UsuariosJpaController();
    CitaJpaController citaJpa = new CitaJpaController();

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PeluCaninaPU");

    // ------------------- Mascotas -------------------
    /**
     * Guarda un nuevo dueño y su mascota en la base de datos.
     *
     * @param duenio Objeto de tipo Duenio que se desea guardar.
     * @param masco Objeto de tipo Mascotas que se desea guardar.
     */
    public void guardar(Duenio duenio, Mascotas masco) {
        try {
            // Guardar dueño primero
            duenioJpa.create(duenio);

            // Guardar servicios si existen
            if (masco.getServicios() != null) {
                for (Servicios s : masco.getServicios()) {
                    if (s.getId_servicio() == 0) {
                        serviciosJpa.create(s); // persistir nuevo servicio
                    } else {
                        serviciosJpa.edit(s);   // actualizar si ya existe
                    }
                }
            }

            // Guardar mascota (ya con dueño y servicios asignados)
            mascoJpa.create(masco);

        } catch (Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Recupera la lista completa de mascotas almacenadas en la base de datos.
     *
     * @return Lista de objetos Mascotas.
     */
    public List<Mascotas> traerMascotas() {
        return mascoJpa.findMascotasEntities();
    }

    /**
     * Elimina una mascota y su dueño asociado de la base de datos.
     *
     * @param num_cliente Identificador único del cliente (mascota y dueño) a
     * eliminar.
     */
    public void borrarMascota(int num_cliente) {
        try {
            // Recuperar la mascota
            Mascotas mascota = mascoJpa.findMascotas(num_cliente);

            if (mascota != null) {
                // Borrar la mascota
                mascoJpa.destroy(num_cliente);

                // Si quieres borrar también al dueño asociado:
                Duenio duenio = mascota.getUnDuenio();
                if (duenio != null) {
                    duenioJpa.destroy(duenio.getId_duenio());
                }
            }
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Recupera una mascota específica según su número de cliente.
     *
     * @param num_cliente Identificador único de la mascota.
     * @return Objeto Mascotas correspondiente al número de cliente.
     */
    public Mascotas traerMascota(int num_cliente) {
        return mascoJpa.findMascotas(num_cliente);
    }

    /**
     * Modifica los datos de una mascota existente en la base de datos.
     *
     * @param masco Objeto Mascotas con los datos actualizados.
     */
    public void modificarMascota(Mascotas masco) {
        try {
            mascoJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ------------------- CRUD Dueños -------------------
    /**
     * Recupera un dueño específico según su identificador.
     *
     * @param id_duenio Identificador único del dueño.
     * @return Objeto Duenio correspondiente al identificador.
     */
    public Duenio traerDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }

    /**
     * Modifica los datos de un dueño existente en la base de datos.
     *
     * @param duenio Objeto Duenio con los datos actualizados.
     */
    public void modificarDuenio(Duenio duenio) {
        try {
            duenioJpa.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ------------------- CRUD Roles -------------------
    /**
     * Guarda un nuevo rol en la base de datos.
     *
     * @param rol Objeto Rol que se desea guardar.
     */
    public void guardarRol(Rol rol) {
        rolJpa.create(rol);
    }

    /**
     * Recupera la lista completa de roles almacenados.
     *
     * @return Lista de objetos Rol.
     */
    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
    }

    /**
     * Recupera un rol específico según su identificador.
     *
     * @param id_rol Identificador único del rol.
     * @return Objeto Rol correspondiente al identificador.
     */
    public Rol traerRol(int id_rol) {
        return rolJpa.findRol(id_rol);
    }

    /**
     * Modifica los datos de un rol existente.
     *
     * @param rol Objeto Rol con los datos actualizados.
     */
    public void modificarRol(Rol rol) {
        try {
            rolJpa.edit(rol);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Elimina un rol de la base de datos.
     *
     * @param id_rol Identificador único del rol a eliminar.
     */
    public void borrarRol(int id_rol) {
        rolJpa.destroy(id_rol);
    }

    // ------------------- CRUD Usuarios -------------------
    /**
     * Guarda un nuevo usuario en la base de datos.
     *
     * @param usuario Objeto Usuarios que se desea guardar.
     */
    public void guardarUsuario(Usuarios usuario) {
        usuarioJpa.create(usuario);
    }

    /**
     * Recupera la lista completa de usuarios almacenados.
     *
     * @return Lista de objetos Usuarios.
     */
    public List<Usuarios> traerUsuarios() {
        return usuarioJpa.findUsuariosEntities();
    }

    /**
     * Recupera un usuario específico según su identificador.
     *
     * @param id_usuario Identificador único del usuario.
     * @return Objeto Usuarios correspondiente al identificador.
     */
    public Usuarios traerUsuario(int id_usuario) {
        return usuarioJpa.findUsuarios(id_usuario);
    }

    /**
     * Modifica los datos de un usuario existente.
     *
     * @param usuario Objeto Usuarios con los datos actualizados.
     */
    public void modificarUsuario(Usuarios usuario) {
        try {
            usuarioJpa.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Elimina un usuario de la base de datos.
     *
     * @param id_usuario Identificador único del usuario a eliminar.
     */
    public void borrarUsuario(int id_usuario) {
        usuarioJpa.destroy(id_usuario);
    }

    /**
     * Busca un usuario por email y contraseña para iniciar sesión.
     *
     * @param email Correo electrónico del usuario.
     * @param pass Contraseña del usuario.
     * @return Usuario encontrado o null si no coincide.
     */
    public Usuarios iniciarSesion(String email, String pass) {
        return usuarioJpa.findUsuarioByEmailAndPass(email, pass);
    }

    //-------------------------- Servicios ----------
    /**
     * Guarda un nuevo servicio en la base de datos.
     *
     * @param servicio Objeto Servicios que se desea guardar.
     */
    public void guardarServicio(Servicios servicio) {
        try {
            serviciosJpa.create(servicio);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el servicio: " + e.getMessage(), e);
        }
    }

    /**
     * Recupera la lista de servicios fijos (Baño, Corte de pelo, Corte de
     * uñas).
     *
     * @return Lista de servicios predefinidos.
     */
    public List<Servicios> traerServiciosFijos() {
        EntityManager em = emf.createEntityManager();
        List<Servicios> lista = em.createQuery(
                "SELECT s FROM Servicios s WHERE s.tipoServicios IN ('Baño','Corte de pelo','Corte de uñas')",
                Servicios.class
        ).getResultList();
        em.close();
        return lista;
    }

    /**
     * Recupera un servicio específico según su identificador.
     *
     * @param idServicio Identificador único del servicio.
     * @return Objeto Servicios correspondiente al identificador.
     */
    public Servicios traerServicio(int idServicio) {
        return serviciosJpa.findServicios(idServicio);
    }

    /**
     * Recupera la lista completa de servicios almacenados.
     *
     * @return Lista de objetos Servicios.
     */
    public List<Servicios> traerServicios() {
        return serviciosJpa.findServiciosEntities();
    }

    /**
     * Busca un servicio por su nombre exacto.
     *
     * @param nombre Nombre del servicio.
     * @return Servicio encontrado o null si no existe.
     */
    public Servicios buscarServicioPorNombre(String nombre) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Servicios> lista = em.createQuery(
                    "SELECT s FROM Servicios s WHERE s.tipoServicios = :nombre",
                    Servicios.class
            ).setParameter("nombre", nombre)
                    .getResultList();

            return lista.isEmpty() ? null : lista.get(0); // devuelve el primero
        } finally {
            em.close();
        }
    }

    /**
     * Actualiza los datos de un servicio existente.
     *
     * @param servicio Objeto Servicios con los datos actualizados.
     */
    public void actualizarServicio(Servicios servicio) {
        try {
            serviciosJpa.edit(servicio);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el servicio: " + e.getMessage(), e);
        }
    }

    /**
     * Elimina un servicio de la base de datos.
     *
     * @param idServicio Identificador único del servicio a eliminar.
     */
    public void eliminarServicio(int idServicio) {
        try {
            serviciosJpa.destroy(idServicio);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el servicio: " + e.getMessage(), e);
        }
    }

    //-------------------------- Cita ----------
    /**
     * Guarda una nueva cita en la base de datos.
     *
     * @param cita Objeto Cita que se desea guardar.
     */
    public void guardarCita(Cita cita) {
        citaJpa.create(cita);
    }

    /**
     * Recupera la lista completa de citas almacenadas.
     *
     * @return Lista de objetos Cita.
     */
    public List<Cita> traerCitas() {
        return citaJpa.findCitaEntities();
    }

    /**
     * Recupera una cita específica según su identificador.
     *
     * @param id Identificador único de la cita.
     * @return Objeto Cita correspondiente al identificador.
     */
    public Cita traerCita(int id) {
        return citaJpa.findCita(id);
    }

    /**
     * Modifica los datos de una cita existente.
     *
     * @param cita Objeto Cita con los datos actualizados.
     * @throws Exception Si ocurre un error durante la edición.
     */
    public void modificarCita(Cita cita) throws Exception {
        citaJpa.edit(cita);
    }

    /**
     * Elimina una cita de la base de datos.
     *
     * @param id Identificador único de la cita a eliminar.
     * @throws Exception Si ocurre un error durante la eliminación.
     */
    public void eliminarCita(int id) throws Exception {
        citaJpa.destroy(id);
    }

    /**
     * Busca una cita por su identificador.
     *
     * @param id Identificador único de la cita.
     * @return Objeto Cita correspondiente al identificador.
     */
    public Cita buscarCitaPorId(int id) {
        return citaJpa.findCita(id);
    }

} // fin class ControladorePersistencia
