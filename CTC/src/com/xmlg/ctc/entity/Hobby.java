package com.xmlg.ctc.entity;



public class Hobby {

	// Fields

	private int HId;
	private String HName;

	// Constructors

	/** default constructor */
	public Hobby() {
	}

	/** minimal constructor */
	public Hobby(String HName) {
		this.HName = HName;
	}


	// Property accessors

	public int getHId() {
		return this.HId;
	}

	public void setHId(int HId) {
		this.HId = HId;
	}

	public String getHName() {
		return this.HName;
	}

	public void setHName(String HName) {
		this.HName = HName;
	}

}