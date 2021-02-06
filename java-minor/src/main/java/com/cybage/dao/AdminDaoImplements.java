package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.model.User;
import com.cybage.model.Video;
import com.cybage.util.DbUtil;

public class AdminDaoImplements implements AdminDaoInterface {

	public int addCourse(Course c) throws Exception {
		String sql = "insert into course(course_name,category_id,course_desc,course_image) values(?,?,?,?)";
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, c.getName());
		ps.setString(3, c.getDesc());
		ps.setBlob(4, c.getCourse_image());
		ps.setInt(2, 2);
		return ps.executeUpdate();
	}

	public int deleteCourse(int id) throws Exception {
		String sql = "delete from course where course_id=?";
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}

	public List<Course> getCourse() throws Exception {
		String sql = "SELECT * from category c, course ce where c.category_id=ce.category_id";

		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Course> courses = new ArrayList<Course>();
		while (rs.next()) {
			Course course = new Course();
			course.setCategory(rs.getString(2));
			course.setId(rs.getInt(4));
			course.setName(rs.getString(5));
			course.setDesc(rs.getString(7));
			course.setCourse_image(rs.getBinaryStream(8));
			courses.add(course);
		}
		return courses;
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
		String sql = "select * from category";

		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Category> categories = new ArrayList<Category>();
		while (rs.next()) {
			Category category = new Category();
			category.setName(rs.getString(2));
			category.setId(rs.getInt(1));
			category.setCategory_url(rs.getString(3));
			categories.add(category);
		}
		return categories;
	}

	public List<Video> getVideo() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select course_name, video_name, duration,video_url from course ce join video v on ce.course_id=v.course_id;";

		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Video> videos = new ArrayList<Video>();
		while (rs.next()) {
			Video v=new Video();
			v.setCourse(rs.getString(1));
			v.setName(rs.getString(2));
			v.setDuration(rs.getString(3));
			v.setUrl(rs.getString(4));
			videos.add(v);
		}
		
		return videos;
	}

	public int addVideo(Video v) throws Exception {
		String sql = "insert into video(course_id,video_name,duration,video_url) values(?,?,?,?)";
		Connection con = DbUtil.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, 1);
		ps.setString(2, v.getName());
		ps.setString(3, v.getDuration());
		ps.setString(4, v.getUrl());
		return ps.executeUpdate();
	}

}
