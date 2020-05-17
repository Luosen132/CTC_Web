package com.xmlg.ctc.entity;


public class Friend{

	// Fields

	private int FId;
	private String userByFNo; 
	private String userByUNo;
	// Constructors


	public Friend() {
	}


	public Friend(String userByFNo, String userByUNo) {
		this.userByFNo = userByFNo;
		this.userByUNo = userByUNo;
	}


	// Property accessors

	public int getFId() {
		return this.FId;
	}

	public void setFId(int FId) {
		this.FId = FId;
	}

	public String getStringByFNo() {
		return this.userByFNo;
	}

	public void setStringByFNo(String userByFNo) {
		this.userByFNo = userByFNo;
	}

	public String getStringByUNo() {
		return this.userByUNo;
	}

	public void setStringByUNo(String userByUNo) {
		this.userByUNo = userByUNo;
	}

	

}