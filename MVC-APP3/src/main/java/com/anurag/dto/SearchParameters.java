package com.anurag.dto;

import java.io.Serializable;

public class SearchParameters implements Serializable{

	private static final long serialVersionUID = 789654;
	
	private Integer studentId;
	private String name,course,mobile;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
