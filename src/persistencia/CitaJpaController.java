package persistencia;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Cita;

/**
 * Controlador JPA para gestionar operaciones CRUD relacionadas con la entidad {@link Cita}.
 * <p>
 * Esta clase permite crear, editar, eliminar, buscar y listar citas almacenadas
 * en la base de datos utilizando JPA y un {@link EntityManager}.
 * </p>
 */
public class CitaJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    /**
     * Constructor que recibe un {@link EntityManagerFactory} externo.
     *
     * @param emf factoría de entidades usada para crear los EntityManager.
     */
    public CitaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Constructor por defecto que inicializa la factoría usando la unidad de persistencia
     * configurada como "PeluCaninaPU".
     */
    public CitaJpaController() {
        emf = Persistence.createEntityManagerFactory("PeluCaninaPU");
    }

    /**
     * Devuelve una nueva instancia de {@link EntityManager}.
     *
     * @return un EntityManager activo.
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // -------------------------------------------------------------------------
    // CRUD
    // -------------------------------------------------------------------------

    /**
     * Persiste una nueva cita en la base de datos.
     *
     * @param cita la cita a crear.
     */
    public void create(Cita cita) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cita);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Edita/actualiza una cita existente en la base de datos.
     *
     * @param cita la cita modificada.
     * @throws Exception si ocurre un error durante la actualización.
     */
    public void edit(Cita cita) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            cita = em.merge(cita);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error al editar la cita: " + ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Elimina una cita de la base de datos según su ID.
     *
     * @param id el identificador de la cita a eliminar.
     * @throws EntityNotFoundException si la cita no existe.
     */
    public void destroy(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Cita cita;
            try {
                cita = em.getReference(Cita.class, id);
                cita.getId(); // Fuerza la carga
            } catch (EntityNotFoundException enfe) {
                throw new EntityNotFoundException("La cita con id " + id + " no existe.");
            }
            em.remove(cita);
            em.getTransaction().commit();
        } finally {
            if (em != null) em.close();
        }
    }

    // -------------------------------------------------------------------------
    // CONSULTAS
    // -------------------------------------------------------------------------

    /**
     * Devuelve todas las citas registradas.
     *
     * @return lista completa de citas.
     */
    public List<Cita> findCitaEntities() {
        return findCitaEntities(true, -1, -1);
    }

    /**
     * Devuelve una lista de citas con paginación.
     *
     * @param maxResults cantidad máxima de resultados.
     * @param firstResult índice inicial de búsqueda.
     * @return lista de citas dentro del rango especificado.
     */
    public List<Cita> findCitaEntities(int maxResults, int firstResult) {
        return findCitaEntities(false, maxResults, firstResult);
    }

    /**
     * Método interno para realizar búsquedas completas o paginadas.
     *
     * @param all si es true se devuelven todas las citas.
     * @param maxResults máximo de registros.
     * @param firstResult posición inicial.
     * @return lista de citas.
     */
    private List<Cita> findCitaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Cita> cq = em.getCriteriaBuilder().createQuery(Cita.class);
            cq.select(cq.from(Cita.class));
            Query q = em.createQuery(cq);

            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }

            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Busca y devuelve todas las citas registradas en una fecha concreta.
     *
     * @param fecha la fecha a buscar (solo día, sin hora).
     * @return lista de citas encontradas en dicha fecha.
     */
    public List<Cita> findCitasByFecha(LocalDate fecha) {
        EntityManager em = getEntityManager();
        try {
            LocalDateTime inicio = fecha.atStartOfDay();
            LocalDateTime fin = fecha.plusDays(1).atStartOfDay();

            TypedQuery<Cita> query = em.createQuery(
                    "SELECT c FROM Cita c WHERE c.fechaHora >= :inicio AND c.fechaHora < :fin",
                    Cita.class
            );
            query.setParameter("inicio", inicio);
            query.setParameter("fin", fin);

            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Busca una cita por su identificador único.
     *
     * @param id el id de la cita.
     * @return la cita encontrada o null si no existe.
     */
    public Cita findCita(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cita.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Retorna la cantidad total de citas almacenadas.
     *
     * @return el número de citas registradas.
     */
    public int getCitaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
            Root<Cita> rt = cq.from(Cita.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}

