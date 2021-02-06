package com.cybage.dao;

import java.sql.SQLException;
import java.util.List;

import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.Video;

public interface AdminDaoInterface {
	public int addCourse(Course c) throws Exception;
	public int addVideo(Video v) throws Exception;
	public int deleteCourse(int id) throws Exception;
	public List<Course> getCourse() throws SQLException, Exception;
	public List<Category> getCategory() throws SQLException, Exception;
	public List<Video> getVideo() throws Exception;
	public Course getCourseById(int id);
	public List<Course> getCourseByCid(int id);
	public boolean updateCourse(Course c);
}