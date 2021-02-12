package com.cybage.model;

import java.io.InputStream;

import javax.sql.rowset.serial.SerialBlob;

import com.mysql.cj.jdbc.Blob;

public class Course {
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", desc=" + desc + ", course_image=" + course_image
				+ ", category=" + category + ", encode=" + encode + ", image=" + image + "]";
	}
	private int id;
	private String name;
	private String desc;
	private InputStream course_image;
	private String category;
	private String encode;
	private SerialBlob image;
	public SerialBlob getImage() {
		return image;
	}
	public void setImage(SerialBlob image) {
		this.image = image;
	}
	public String getEncode() {
		return encode;
	}
	public Course(int id, String name, String desc, InputStream course_image) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.course_image = course_image;
	}
	public void setEncode(String encode) {
		this.encode = encode;
	}
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((course_image == null) ? 0 : course_image.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((encode == null) ? 0 : encode.hashCode());
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	
	
	
}
