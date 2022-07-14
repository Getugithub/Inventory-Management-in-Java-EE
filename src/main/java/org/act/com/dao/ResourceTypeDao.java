package org.act.com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.act.com.model.ResourceType;

/**
 * DAO for ResourceType
 */
@Stateless
public class ResourceTypeDao {
	@PersistenceContext(unitName = "Inventory-management-system-persistence-unit")
	private EntityManager em;

	public void create(ResourceType entity) {
		em.persist(entity);
	}

	public void deleteById(int id) {
		ResourceType entity = em.find(ResourceType.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public ResourceType findById(int id) {
		return em.find(ResourceType.class, id);
	}

	public ResourceType update(ResourceType entity) {
		return em.merge(entity);
	}

	public List<ResourceType> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<ResourceType> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT r FROM ResourceType r LEFT JOIN FETCH r.resourceses ORDER BY r.id",
						ResourceType.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
