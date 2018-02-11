package com.anurag.service;

import java.util.List;

import com.anurag.dto.SearchParameters;
import com.anurag.dto.SearchResults;

public interface StudentService {

	public List<SearchResults> searchStudents(SearchParameters searchParameters);

}
