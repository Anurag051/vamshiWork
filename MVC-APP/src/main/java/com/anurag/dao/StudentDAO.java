package com.anurag.dao;

import java.util.List;

import com.anurag.dto.SearchParameters;
import com.anurag.dto.SearchResults;

public interface StudentDAO {

	public List<SearchResults> searchStudents(SearchParameters searchParameters);

}
