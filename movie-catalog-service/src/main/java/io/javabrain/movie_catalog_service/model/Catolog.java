package io.javabrain.movie_catalog_service.model;

public class Catolog {
	private String name;
	private String desc;
	private int rating;
	
	public Catolog(String name, String desc, int rating) {
		super();
		this.name = name;
		this.desc = desc;
		this.rating = rating;
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
	public int getRange() {
		return rating;
	}
	public void setRange(int range) {
		this.rating = rating;
	}
	
	
}
