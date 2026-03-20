package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import logica.Usuarios;

public class UsuariosJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public UsuariosJpaController() {
        this.emf = Persistence.createEntityManagerFactory("PeluCaninaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear un nuevo usuario
    public void create(Usuarios usuario) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Editar un usuario existente
    public void edit(Usuarios usuario) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            usuario = em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error al editar el usuario: " + ex.getMessage());
        } finally {
            em.close();
        }
    }

    // Eliminar un usuario por ID
    public void destroy(int id_usuario) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Usuarios usuario = em.getReference(Usuarios.class, id_usuario);
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Buscar un usuario por ID
    public Usuarios findUsuarios(int id_usuario) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuarios.class, id_usuario);
        } finally {
            em.close();
        }
    }

    // Listar todos los usuarios
    public List<Usuarios> findUsuariosEntities() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuarios.class));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Usuarios findUsuarioByEmailAndPass(String email, String pass) {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT u FROM Usuarios u WHERE u.email = :email AND u.pass = :pass";
            return em.createQuery(jpql, Usuarios.class)
                    .setParameter("email", email)
                    .setParameter("pass", pass)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);
        } finally {
            em.close();
        }
    }
}
