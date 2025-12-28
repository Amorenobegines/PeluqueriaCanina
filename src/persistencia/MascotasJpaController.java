package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Mascotas;
import persistencia.exceptions.NonexistentEntityException;

/**
 * Controlador JPA para la entidad Mascotas.
 * Proporciona métodos para realizar operaciones CRUD y consultas personalizadas
 * sobre la base de datos que gestiona mascotas en la peluquería canina.
 * 
 * @author Alicia
 */
public class MascotasJpaController implements Serializable {

    
     private EntityManagerFactory emf = null;
     
    /**
     * Constructor que recibe una fábrica de entidades para inicializar el EntityManager.
     *
     * @param emf EntityManagerFactory proporcionado externamente.
     */
    public MascotasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * Constructor por defecto que inicializa la fábrica de entidades con la unidad de persistencia "PeluCaninaPU".
     */
    public MascotasJpaController() {
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
     * Crea una nueva mascota en la base de datos.
     *
     * @param mascotas Objeto Mascotas que se desea persistir.
     */
    public void create(Mascotas mascotas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mascotas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

     /**
     * Edita una mascota existente en la base de datos.
     *
     * @param mascotas Objeto Mascotas con los datos actualizados.
     * @throws NonexistentEntityException Si la mascota no existe en la base de datos.
     * @throws Exception Si ocurre otro error durante la edición.
     */
    public void edit(Mascotas mascotas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mascotas = em.merge(mascotas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = mascotas.getNum_cliente();
                if (findMascotas(id) == null) {
                    throw new NonexistentEntityException("The mascotas with id " + id + " no longer exists.");
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
     * Elimina una mascota de la base de datos según su ID.
     *
     * @param id Identificador único de la mascota.
     * @throws NonexistentEntityException Si la mascota no existe.
     */
    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mascotas mascotas;
            try {
                mascotas = em.getReference(Mascotas.class, id);
                mascotas.getNum_cliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mascotas with id " + id + " no longer exists.", enfe);
            }
            em.remove(mascotas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Recupera todas las mascotas registradas en la base de datos.
     *
     * @return Lista de objetos Mascotas.
     */
    public List<Mascotas> findMascotasEntities() {
        return findMascotasEntities(true, -1, -1);
    }

    /**
     * Recupera una lista paginada de mascotas.
     *
     * @param maxResults Número máximo de resultados.
     * @param firstResult Índice del primer resultado.
     * @return Lista de objetos Mascotas.
     */
    public List<Mascotas> findMascotasEntities(int maxResults, int firstResult) {
        return findMascotasEntities(false, maxResults, firstResult);
    }

    /**
     * Método interno para recuperar mascotas con o sin paginación.
     *
     * @param all Si es true, recupera todas las mascotas.
     * @param maxResults Número máximo de resultados.
     * @param firstResult Índice del primer resultado.
     * @return Lista de objetos Mascotas.
     */
    private List<Mascotas> findMascotasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mascotas.class));
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
     * Busca una mascota específica por su ID.
     *
     * @param id Identificador único de la mascota.
     * @return Objeto Mascotas correspondiente al ID.
     */
    public Mascotas findMascotas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mascotas.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Obtiene el número total de mascotas registradas.
     *
     * @return Cantidad total de mascotas.
     */
    public int getMascotasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mascotas> rt = cq.from(Mascotas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    /**
     * Busca mascotas cuyo dueño tenga un nombre que coincida (parcialmente) con el proporcionado.
     *
     * @param nombreDueno Nombre (o parte del nombre) del dueño.
     * @return Lista de mascotas cuyos dueños coinciden con el nombre dado.
     */
    public List<Mascotas> findMascotasByNombreDueno(String nombreDueno) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Mascotas> query = em.createQuery(
                    "SELECT m FROM Mascotas m WHERE LOWER(m.unDuenio.nombre) LIKE LOWER(:nombreDueno)",
                    Mascotas.class
            );
            query.setParameter("nombreDueno", "%" + nombreDueno + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}  
