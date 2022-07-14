package org.act.com.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.act.com.model.Employee;

/**
 * DAO for Employee
 */
@Stateless
public class EmployeeDao {
	@PersistenceContext(unitName = "Inventory-management-system-persistence-unit")
	private EntityManager em;

	public void create(Employee entity) {
		em.persist(entity);
	}

	public void deleteById(long id) {
		Employee entity = em.find(Employee.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Employee findById(long id) {
		return em.find(Employee.class, id);
	}

	public Employee update(Employee entity) {
		return em.merge(entity);
	}

	public List<Employee> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Employee> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT e FROM Employee e LEFT JOIN FETCH e.departments " +
								" ORDER BY e.id",
						Employee.class);

		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}

	public List<Employee> employeeDepartmentById(Integer departmentId) {
		TypedQuery<Employee> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT e FROM Employee e" +
								" LEFT JOIN FETCH e.departments where e.departments.id=:departId " +
								" ORDER BY e.id",
						Employee.class).setParameter("departId",departmentId);
		return findAllQuery.getResultList();
	}

	public List<Employee> searchEmployeeByName(String employeeName) {
		TypedQuery<Employee> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT e FROM Employee e" +
								" LEFT JOIN FETCH e.departments where e.name like :nameOfemployee" +
								" ORDER BY e.id",
						Employee.class).setParameter("nameOfemployee",employeeName);
		return findAllQuery.getResultList();
	}

	public List<Employee> searchEmployeeByNameAndEmail(String search) {
		TypedQuery<Employee> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT e FROM Employee e" +
								" LEFT JOIN FETCH e.departments where " +
								" e.name like :nameOfemployee or " +
								" e.email like :emailOfemployee " +
								" ORDER BY e.id", Employee.class)
				                .setParameter("nameOfemployee",search)
				                .setParameter("emailOfemployee",search);
		return findAllQuery.getResultList();
	}

}
