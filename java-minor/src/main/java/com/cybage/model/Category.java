package com.cybage.model;

public class Category {
	private int id;
	private String name;
	private String category_url;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
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
