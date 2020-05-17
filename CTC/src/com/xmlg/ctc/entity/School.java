package com.xmlg.ctc.entity;


public class School {

	// Fields

	private Integer schId;
	private String schName;

	// Constructors

	/** default constructor */
	public School() {
	}

	/** minimal constructor */
	public School(String schName) {
		this.schName = schName;
	}


	// Property accessors

	public Integer getSchId() {
		return this.schId;
	}

	public void setSchId(Integer schId) {
		this.schId = schId;
	}

	public String getSchName() {
		return this.schName;
	}

	public void setSchName(String schName) {
		this.schName = schName;
	}

}