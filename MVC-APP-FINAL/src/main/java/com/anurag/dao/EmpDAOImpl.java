package com.anurag.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anurag.model.Employee;

@SuppressWarnings("deprecation")
@Repository
public class EmpDAOImpl implements EmpDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public long save(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);
		return emp.getEid();
	}

	public Employee get(long id) {
		return sessionFactory.getCurrentSession().get(Employee.class, id);//get & load to single row data from DB
	}

	public List<Employee> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.select(root);
		Query<Employee> query = session.createQuery(cq);
		return query.getResultList();
	}

	public void update(long id, Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp1 = session.byId(Employee.class).load(id);
		emp1.setName(emp.getName());
		emp1.setDept(emp.getDept());
		session.flush();

	}

	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = session.byId(Employee.class).load(id);
		session.delete(emp);

	}

}
