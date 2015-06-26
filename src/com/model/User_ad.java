package com.model;

public class User_ad {

	private int id;
	private int ad_id;
	private int user_id;
	
	
	public User_ad() {
		// TODO Auto-generated constructor stub
	}


	public User_ad(int id, int ad_id, int user_id) {
		super();
		this.id = id;
		this.ad_id = ad_id;
		this.user_id = user_id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getAd_id() {
		return ad_id;
	}


	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	
	
	
	
}
