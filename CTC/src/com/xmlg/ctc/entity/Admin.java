package com.xmlg.ctc.entity;

public class Admin {
	private int AdId;
	private String AdminName;
	private String AdminPassword;
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Admin(String adminName, String adminPassword) {
		super();
		AdminName = adminName;
		AdminPassword = adminPassword;
	}

	public Admin(int adId, String adminName, String adminPassword) {
		super();
		AdId = adId;
		AdminName = adminName;
		AdminPassword = adminPassword;
	}
	public int getAdId() {
		return AdId;
	}
	public void setAdId(int adId) {
		AdId = adId;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getAdminPassword() {
		return AdminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}
	
	
	
}
