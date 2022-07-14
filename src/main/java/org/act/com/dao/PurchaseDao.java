package org.act.com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.act.com.model.Purchase;

/**
 * DAO for Purchase
 */
@Stateless
public class PurchaseDao {
	@PersistenceContext(unitName = "Inventory-management-system-persistence-unit")
	private EntityManager em;

	public void create(Purchase entity) {
		em.persist(entity);
	}

	public void deleteById(long id) {
		Purchase entity = em.find(Purchase.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Purchase findById(long id) {
		return em.find(Purchase.class, id);
	}

	public Purchase update(Purchase entity) {
		return em.merge(entity);
	}

	public List<Purchase> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Purchase> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT p FROM Purchase p LEFT JOIN FETCH p.purchaseRequest LEFT JOIN FETCH p.resources ORDER BY p.id",
						Purchase.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
