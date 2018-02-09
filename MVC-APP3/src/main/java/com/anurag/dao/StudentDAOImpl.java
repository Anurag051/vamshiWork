package com.anurag.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private SessionFactory factory;

}
