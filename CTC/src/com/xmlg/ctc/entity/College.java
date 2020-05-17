package com.xmlg.ctc.entity;

public class College {

	// Fields

	private int colId;
	private String colName;
	// Constructors

	/** default constructor */
	public College() {
	}

	/** minimal constructor */
	public College(String colName) {
		this.colName = colName;
	}



	// Property accessors

	public int getColId() {
		return this.colId;
	}

	public void setColId(int colId) {
		this.colId = colId;
	}

	public String getColName() {
		return this.colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

}