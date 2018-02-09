package com.anurag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.dao.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDAO dao;

}
