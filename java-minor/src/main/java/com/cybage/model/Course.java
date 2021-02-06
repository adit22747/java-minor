package com.cybage.model;

import java.io.InputStream;

public class Course {
	private int id;
	private String name;
	private String desc;
	private InputStream course_image;
	private String category;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public InputStream getCourse_image() {
		return course_image;
	}
	public void setCourse_image(InputStream course_image) {
		this.course_image = course_image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Course(int id, String name, String desc, InputStream course_image, String category) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.course_image = course_image;
		this.category = category;
	}
	public Course(String name, String desc, InputStream course_image, String category) {
		super();
		this.name = name;
		this.desc = desc;
		this.course_image = course_image;
		this.category = category;
	}
	public Course() {
		super();
	}
	public Course(String name, String desc, InputStream course_image) {
		super();
		this.name = name;
		this.desc = desc;
		this.course_image = course_image;
	}
	
	
	
	
}
