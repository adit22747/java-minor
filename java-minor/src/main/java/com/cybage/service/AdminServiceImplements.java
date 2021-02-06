package com.cybage.service;

import java.sql.SQLException;
import java.util.List;

import com.cybage.dao.AdminDaoImplements;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.Video;

public class AdminServiceImplements implements AdminServiceInterface {
	private AdminDaoImplements ad;

	public AdminServiceImplements(AdminDaoImplements ad) {
		super();
		this.ad = ad;
	}

	public int addCourse(Course c) throws Exception {
		// TODO Auto-generated method stub
		return ad.addCourse(c);
	}

	public int deleteCourse(int id) throws Exception {
		// TODO Auto-generated method stub
		return ad.deleteCourse(id);
	}

	public List<Course> getCourse() throws Exception {
		// TODO Auto-generated method stub
		return ad.getCourse();
	}

	public Course getCourseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Course> getCourseByCid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateCourse(Course c) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Category> getCategory() throws Exception {
		// TODO Auto-generated method stub
	return ad.getCategory();
	}

	public int addVideo(Video v) throws Exception {
		// TODO Auto-generated method stub
		return ad.addVideo(v);
	}

}
