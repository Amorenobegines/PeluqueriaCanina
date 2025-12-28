
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Servicios;

public class ServiciosJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public ServiciosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("PeluCaninaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear un nuevo servicio
    public void create(Servicios servicio) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(servicio);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Editar un servicio existente
    public void edit(Servicios servicio) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            servicio = em.merge(servicio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error al editar el servicio: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    // Eliminar un servicio por ID
    public void destroy(int id_servicio) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Servicios servicio = em.getReference(Servicios.class, id_servicio);
            em.remove(servicio);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Buscar un servicio por ID
    public Servicios findServicios(int id_servicio) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Servicios.class, id_servicio);
        } finally {
            em.close();
        }
    }

    // Listar todos los servicios
    public List<Servicios> findServiciosEntities() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Servicios.class));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}

