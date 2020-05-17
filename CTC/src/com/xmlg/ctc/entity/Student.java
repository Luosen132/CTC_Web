package com.xmlg.ctc.entity;


public class Student {

	// Fields

	private String SNo;
	private int college;
	private int school;
	private String SName;
	private String SIdcard;
	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(int college, int school, String SName, String SIdcard) {
		this.college = college;
		this.school = school;
		this.SName = SName;
		this.SIdcard = SIdcard;
	}



	// Property accessors

	public String getSNo() {
		return this.SNo;
	}

	public void setSNo(String SNo) {
		this.SNo = SNo;
	}

	public int getCollege() {
		return this.college;
	}

	public void setCollege(int college) {
		this.college = college;
	}

	public int getSchool() {
		return this.school;
	}

	public void setSchool(int school) {
		this.school = school;
	}

	public String getSName() {
		return this.SName;
	}

	public void setSName(String SName) {
		this.SName = SName;
	}

	public String getSIdcard() {
		return this.SIdcard;
	}

	public void setSIdcard(String SIdcard) {
		this.SIdcard = SIdcard;
	}



}