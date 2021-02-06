package com.cybage.service;

import java.sql.SQLException;
import java.util.List;

import com.cybage.model.Category;
import com.cybage.model.Course;

public interface AdminServiceInterface {
	public int addCourse(Course c) throws Exception;
	public int deleteCourse(int id) throws Exception;
	public List<Course> getCourse() throws Exception;
	public Course getCourseById(int id);
	public List<Course> getCourseByCid(int id);
	public boolean updateCourse(Course c);
	public List<Category> getCategory() throws SQLException, Exception;

}