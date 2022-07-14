package org.act.com.dao;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.act.com.model.PurchaseRequest;

/**
 * DAO for PurchaseRequest
 */
@Stateless
public class PurchaseRequestDao {
	@PersistenceContext(unitName = "Inventory-management-system-persistence-unit")
	private EntityManager em;

	public void create(PurchaseRequest entity) {
		em.persist(entity);
	}

	public void deleteById(long id) {
		PurchaseRequest entity = em.find(PurchaseRequest.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public PurchaseRequest findById(long id) {
		return em.find(PurchaseRequest.class, id);
	}

	public PurchaseRequest update(PurchaseRequest entity) {
		return em.merge(entity);
	}

	public List<PurchaseRequest> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<PurchaseRequest> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT p FROM PurchaseRequest p LEFT JOIN FETCH p.employee ORDER BY p.id",
						PurchaseRequest.class);
		if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
