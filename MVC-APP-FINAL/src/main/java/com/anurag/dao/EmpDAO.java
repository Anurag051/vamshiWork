package com.anurag.dao;

import java.util.List;

import com.anurag.model.Employee;

public interface EmpDAO {

	public long save(Employee emp);

	public Employee get(long id);

	public List<Employee> list();

	public void update(long id, Employee emp);

	public void delete(long id);

}
