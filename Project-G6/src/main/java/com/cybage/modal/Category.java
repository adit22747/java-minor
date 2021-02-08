package com.cybage.modal;

import java.io.InputStream;

public class Category {
	private int id;
	private String name;
	private String category_url;
	private InputStream category_image;
	private String encode;
	public Category(int id, String name, InputStream category_image) {
		super();
		this.id = id;
		this.name = name;
		this.category_image = category_image;
	}
	public int getId() {
		return id;
	}
	public Category(String name, InputStream category_image) {
		super();
		this.name = name;
		this.category_image = category_image;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public InputStream getCategory_image() {
		return category_image;
	}
	public void setCategory_image(InputStream category_image) {
		this.category_image = category_image;
	}
	public String getEncode() {
		return encode;
	}
	public void setEncode(String encode) {
		this.encode = encode;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory_url() {
		return category_url;
	}
	public void setCategory_url(String category_url) {
		this.category_url = category_url;
	}
	public Category(int id, String name, String category_url) {
		super();
		this.id = id;
		this.name = name;
		this.category_url = category_url;
	}

	public Category(String name, String category_url) {
		super();
		this.name = name;
		this.category_url = category_url;
	}
	public Category() {
		// TODO Auto-generated constructor stub
	}

}
