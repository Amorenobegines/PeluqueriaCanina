package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Rol;

public class RolJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public RolJpaController() {
        this.emf = Persistence.createEntityManagerFactory("PeluCaninaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear un nuevo rol
    public void create(Rol rol) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rol);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Editar un rol existente
    public void edit(Rol rol) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            rol = em.merge(rol);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error al editar el rol: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    // Eliminar un rol por ID
    public void destroy(int id_rol) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Rol rol = em.getReference(Rol.class, id_rol);
            em.remove(rol);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Buscar un rol por ID
    public Rol findRol(int id_rol) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rol.class, id_rol);
        } finally {
            em.close();
        }
    }

    // Listar todos los roles
    public List<Rol> findRolEntities() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rol.class));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}

