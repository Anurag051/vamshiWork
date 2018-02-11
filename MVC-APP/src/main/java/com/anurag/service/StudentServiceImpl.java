package com.anurag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anurag.dao.StudentDAO;
import com.anurag.dto.SearchParameters;
import com.anurag.dto.SearchResults;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDAO dao;

	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}

	public List<SearchResults> searchStudents(SearchParameters searchParameters) {
		List<SearchResults> results=dao.searchStudents(searchParameters);
		return results;
	}
	
	

}
