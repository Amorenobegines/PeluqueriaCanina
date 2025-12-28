
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Duenio;
import persistencia.exceptions.NonexistentEntityException;

/**
 * Controlador JPA para la entidad Duenio.
 * Proporciona métodos para realizar operaciones CRUD y consultas sobre los datos
 * de los dueños registrados en la base de datos de la peluquería canina.
 * 
 * @author Alicia
 */
public class DuenioJpaController implements Serializable {

    /**
     * Constructor que inicializa el controlador con una fábrica de entidades proporcionada.
     *
     * @param emf EntityManagerFactory externo para la gestión de persistencia.
     */
    public DuenioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    /**
     * Constructor por defecto que inicializa la fábrica de entidades con la unidad de persistencia "PeluCaninaPU".
     */
    public DuenioJpaController() {
        emf = Persistence.createEntityManagerFactory("PeluCaninaPU");
    }
    
    /**
     * Obtiene una instancia de EntityManager para interactuar con la base de datos.
     *
     * @return EntityManager activo.
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Persiste un nuevo objeto Duenio en la base de datos.
     *
     * @param duenio Objeto Duenio que se desea guardar.
     */
    public void create(Duenio duenio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(duenio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Actualiza los datos de un dueño existente en la base de datos.
     *
     * @param duenio Objeto Duenio con los datos modificados.
     * @throws NonexistentEntityException Si el dueño no existe en la base de datos.
     * @throws Exception Si ocurre otro error durante la operación.
     */
    public void edit(Duenio duenio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            duenio = em.merge(duenio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = duenio.getId_duenio();
                if (findDuenio(id) == null) {
                    throw new NonexistentEntityException("The duenio with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Elimina un dueño de la base de datos según su ID.
     *
     * @param id Identificador único del dueño.
     * @throws NonexistentEntityException Si el dueño no existe.
     */
    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Duenio duenio;
            try {
                duenio = em.getReference(Duenio.class, id);
                duenio.getId_duenio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The duenio with id " + id + " no longer exists.", enfe);
            }
            em.remove(duenio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

     /**
     * Recupera todos los dueños registrados en la base de datos.
     *
     * @return Lista de objetos Duenio.
     */
    public List<Duenio> findDuenioEntities() {
        return findDuenioEntities(true, -1, -1);
    }

    /**
     * Recupera una lista paginada de dueños.
     *
     * @param maxResults Número máximo de resultados.
     * @param firstResult Índice del primer resultado.
     * @return Lista de objetos Duenio.
     */
    public List<Duenio> findDuenioEntities(int maxResults, int firstResult) {
        return findDuenioEntities(false, maxResults, firstResult);
    }

     /**
     * Método interno para recuperar dueños con o sin paginación.
     *
     * @param all Si es true, recupera todos los dueños.
     * @param maxResults Número máximo de resultados.
     * @param firstResult Índice del primer resultado.
     * @return Lista de objetos Duenio.
     */
    private List<Duenio> findDuenioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Duenio.class));
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
     * Busca un dueño específico por su ID.
     *
     * @param id Identificador único del dueño.
     * @return Objeto Duenio correspondiente al ID.
     */
    public Duenio findDuenio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Duenio.class, id);
        } finally {
            em.close();
        }
    }

     /**
     * Obtiene el número total de dueños registrados.
     *
     * @return Cantidad total de dueños.
     */
    public int getDuenioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Duenio> rt = cq.from(Duenio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
