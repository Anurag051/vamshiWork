package com.anurag.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anurag.dto.SearchParameters;
import com.anurag.dto.SearchResults;

@SuppressWarnings("deprecation")
@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	public List<SearchResults> searchStudents(SearchParameters searchParameters) {
		List<SearchResults> searchResults = new ArrayList<SearchResults>();
		StringBuffer sb = new StringBuffer(
				"select s.studentId,s.name,s.mobile,s.course,s.city,s.state from com.anurag.domain.Student as s");
		boolean isFirst = true;
		if (searchParameters != null) {
			if (searchParameters.getStudentId() != null && searchParameters.getStudentId() > 0) {
				sb.append(" where s.studentId=" + searchParameters.getStudentId());
				isFirst = false;
			}
			if (searchParameters.getName() != null && searchParameters.getName().trim().length() > 0) {
				if (isFirst) {
					sb.append(" where s.name like '%" + searchParameters.getName() + "%'");
					isFirst = false;
				} else {
					sb.append(" AND s.name like '%" + searchParameters.getName() + "%'");
				}
			}
			if (searchParameters.getCourse() != null && searchParameters.getCourse().trim().length() > 0) {
				if (isFirst) {
					sb.append(" where s.course like '" + searchParameters.getCourse() + "'");
					isFirst = false;
				} else {
					sb.append(" AND s.course like '" + searchParameters.getCourse() + "'");
				}
			}
			if (searchParameters.getMobile() != null && searchParameters.getMobile().trim().length() > 0) {
				if (isFirst) {
					sb.append(" where s.mobile like '" + searchParameters.getMobile() + "'");
					isFirst = false;
				} else {
					sb.append(" AND s.mobile like '" + searchParameters.getMobile() + "'");
				}
			}

			Session session = factory.openSession();
			Query<Object[]> query = session.createQuery(sb.toString());
			List<Object[]> list = query.list();
			//System.out.println("<<<<<<<<<<<<<<<<List Size>>>>>>>"+list.size());
			for (Object[] obj : list) {
				SearchResults results = new SearchResults();
				results.setStudentId((Integer) obj[0]);
				results.setName((String) obj[1]);
				results.setMobile((String) obj[2]);
				results.setCourse((String) obj[3]);
				results.setCity((String) obj[4]);
				results.setState((String) obj[5]);
				//System.out.println(results.toString());
				searchResults.add(results);
			}

		}
		//System.out.println("<<<<<<<<<<<<<size Final>>>>>>>>>>"+searchResults.size());
		return searchResults;
	}

}
