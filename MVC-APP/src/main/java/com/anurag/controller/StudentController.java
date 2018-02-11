package com.anurag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anurag.dto.SearchParameters;
import com.anurag.dto.SearchResults;
import com.anurag.service.StudentService;
import com.anurag.util.AnuragConstants;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	private static final String WEB_SEARCH_STUDENTS = "/searchStudents.do";

	private static final String WEB_SEARCH_STUDENTS_PAGE = "/WEB-INF/view/searchStudents.jsp";

	private static final String WEB_SEARCH_RESULTS_PAGE = "/WEB-INF/view/searchResults.jsp";

	@RequestMapping(value = WEB_SEARCH_STUDENTS, method = RequestMethod.GET)
	public String showSearchStudentsPage() {
		return WEB_SEARCH_STUDENTS_PAGE;
	}

	@RequestMapping(value = WEB_SEARCH_STUDENTS, method = RequestMethod.POST)
	public ModelAndView searchStudents(@RequestParam(AnuragConstants.CONST_STUDENT_ID) Integer studentId,
			@RequestParam(AnuragConstants.CONST_STUDENT_NAME) String name,
			@RequestParam(AnuragConstants.CONST_STUDENT_COURSE) String course,
			@RequestParam(AnuragConstants.CONST_STUDENT_MOBILE) String mobile) {
		SearchParameters searchParameters = new SearchParameters();
		searchParameters.setStudentId(studentId);
		searchParameters.setName(name);
		searchParameters.setCourse(course);
		searchParameters.setMobile(mobile);
		List<SearchResults> searchResults = studentService.searchStudents(searchParameters);//went to service layer
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(WEB_SEARCH_RESULTS_PAGE);
		/*for (SearchResults searchResults2 : searchResults) {
			System.out.println(searchResults2);
		}*/
		modelAndView.addObject(AnuragConstants.CONST_SEARCH_RESULTS, searchResults);
		return modelAndView;

	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}
