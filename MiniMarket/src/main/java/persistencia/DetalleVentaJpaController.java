
package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import logica.DetalleVenta;
import persistencia.exceptions.NonexistentEntityException;

public class DetalleVentaJpaController implements Serializable {

	public List<DetalleVenta> listaDetVenta = new ArrayList<>();

	public DetalleVentaJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}

	private EntityManagerFactory emf = null;

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public DetalleVentaJpaController() {
		emf = Persistence.createEntityManagerFactory("Minimarket");
	}

	public void create(DetalleVenta detVenta) {
		listaDetVenta.add(detVenta);
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(detVenta);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(DetalleVenta detVenta) throws NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			detVenta = em.merge(detVenta);
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				int id = detVenta.getId();
				if (findDetalleVenta(id) == null) {
					throw new NonexistentEntityException("The DetalleVenta with id " + id + " no longer exists.");
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
			DetalleVenta detVenta;
			try {
				detVenta = em.getReference(DetalleVenta.class, id);
				detVenta.getId();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The DetalleVenta with id " + id + " no longer exists.", enfe);
			}
			em.remove(detVenta);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<DetalleVenta> findDetalleVentaEntities() {
		return findDetalleVentaEntities(true, -1, -1);
	}

	public List<DetalleVenta> findDetalleVentaEntities(int maxResults, int firstResult) {
		return findDetalleVentaEntities(false, maxResults, firstResult);
	}

	private List<DetalleVenta> findDetalleVentaEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(DetalleVenta.class));
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

	public DetalleVenta findDetalleVenta(int id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(DetalleVenta.class, id);
		} finally {
			em.close();
		}
	}

	public int getDetalleVentaCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<DetalleVenta> rt = cq.from(DetalleVenta.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long) q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}

}
