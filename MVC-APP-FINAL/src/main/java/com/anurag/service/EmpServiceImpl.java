package com.anurag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anurag.dao.EmpDAO;
import com.anurag.model.Employee;

@Service
@Transactional(readOnly = true)
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDAO empDao;

	@Transactional
	public long save(Employee emp) {
		return empDao.save(emp);
	}

	public Employee get(long id) {
		return empDao.get(id);
	}

	public List<Employee> list() {
		return empDao.list();
	}

	@Transactional
	public void update(long id, Employee emp) {
		empDao.update(id, emp);

	}

	@Transactional
	public void delete(long id) {
		empDao.delete(id);

	}

}
