package com.cybage.dao;

import java.sql.SQLException;
import java.util.List;

import com.cybage.modal.Category;
import com.cybage.modal.Course;
import com.cybage.modal.Video;

public interface AdminDaoInterface {
	public int addCourse(Course c,int Category_id) throws Exception;
	public boolean deleteCourse(int id) throws Exception;
	public boolean deleteCategory(int id) throws Exception;
	public boolean deleteVideo(int id) throws Exception;
	public List<Course> getCourse() throws SQLException, Exception;
	public List<Category> getCategory() throws SQLException, Exception;
	public List<Video> getVideo() throws Exception;
	public Course getCourseById(int id);
	public List<Course> getCourseByCid(int id);
	public boolean updateCourse(Course c) throws Exception;
	public boolean updateVideo(Video v) throws Exception;
	public int addVideo(Video v,int course_id) throws Exception;
	public boolean updateCategory(Category c) throws Exception;
	public int addCategory(Category c) throws Exception;
	
}