package com.model;

public class Ad {

	private int id;
	private String header;
	private String details;
	private int adcategory_id;
	private int user_id;
	
	
	public Ad() {
		// TODO Auto-generated constructor stub
	}


	public Ad(int id, String header, String details, int adcategory_id,
			int user_id) {
		super();
		this.id = id;
		this.header = header;
		this.details = details;
		this.adcategory_id = adcategory_id;
		this.user_id = user_id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getHeader() {
		return header;
	}


	public void setHeader(String header) {
		this.header = header;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public int getAdcategory_id() {
		return adcategory_id;
	}


	public void setAdcategory_id(int adcategory_id) {
		this.adcategory_id = adcategory_id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	
	
	
	
	
}
