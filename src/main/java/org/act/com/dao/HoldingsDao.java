package org.act.com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.act.com.model.Holdings;
import org.act.com.model.Resources;

/**
 * DAO for Holdings
 */
@Stateless
public class HoldingsDao {
    @PersistenceContext(unitName = "Inventory-management-system-persistence-unit")
    private EntityManager em;

    public void create(Holdings entity) {
        em.persist(entity);
    }

    public void deleteById(long id) {
        Holdings entity = em.find(Holdings.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public Holdings findById(long id) {
        return em.find(Holdings.class, id);
    }

    public Holdings update(Holdings entity) {
        return em.merge(entity);
    }


    public List<Holdings> listAll(Integer startPosition, Integer maxResult) {

        TypedQuery<Holdings> findAllQuery = em
                .createQuery(
                        "SELECT DISTINCT h FROM Holdings h LEFT JOIN FETCH h.employee e left JOIN fetch e.departments LEFT JOIN FETCH h.resources ORDER BY h.id",
                        Holdings.class);

        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        return findAllQuery.getResultList();
    }
}
