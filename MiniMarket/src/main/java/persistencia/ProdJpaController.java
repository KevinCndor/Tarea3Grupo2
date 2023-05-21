
package persistencia;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import logica.Productos;
import persistencia.exceptions.NonexistentEntityException;

public class ProdJpaController implements Serializable {

	public ProdJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	private EntityManagerFactory emf = null;

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public ProdJpaController() {
		emf = Persistence.createEntityManagerFactory("Minimarket");
	}

	public void create(Productos producto) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(producto);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Productos producto) throws NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			producto = em.merge(producto);
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				int id = producto.getId();
				if (findProducto(id) == null) {
					throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
				}
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void destroy(int id) throws NonexistentEntityException {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Productos producto;
			try {
				producto = em.getReference(Productos.class, id);
				producto.getId();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
			}
			em.remove(producto);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Productos> findProductoEntities() {
		return findProductoEntities(true, -1, -1);
	}

	public List<Productos> findProductoEntities(int maxResults, int firstResult) {
		return findProductoEntities(false, maxResults, firstResult);
	}

	private List<Productos> findProductoEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Productos.class));
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

	public Productos findProducto(int id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Productos.class, id);
		} finally {
			em.close();
		}
	}

	public int getProductosCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Productos> rt = cq.from(Productos.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long) q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}

}
