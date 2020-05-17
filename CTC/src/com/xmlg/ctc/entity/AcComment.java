package com.xmlg.ctc.entity;



public class AcComment {

	// Fields

	private int acCoId;
	private int acId;
	private String acCoNo;
	private String acCoContent;
	private String acCoDate;

	// Constructors

	/** default constructor */
	public AcComment() {
	}

	/** full constructor */
	public AcComment(int acid, String accono, String acCoContent,
			String acCoDate) {
		this.acId = acid;
		this.acCoNo = accono;
		this.acCoContent = acCoContent;
		this.acCoDate = acCoDate;
	}

	// Property accessors

	public Integer getAcCoId() {
		return this.acCoId;
	}

	public void setAcCoId(Integer acCoId) {
		this.acCoId = acCoId;
	}





	public int getAcid() {
		return acId;
	}

	public void setAcid(int acid) {
		this.acId = acid;
	}

	public String getAccono() {
		return acCoNo;
	}

	public void setAccono(String accono) {
		this.acCoNo = accono;
	}

	public String getAcCoContent() {
		return this.acCoContent;
	}

	public void setAcCoContent(String acCoContent) {
		this.acCoContent = acCoContent;
	}

	public String getAcCoDate() {
		return this.acCoDate;
	}

	public void setAcCoDate(String acCoDate) {
		this.acCoDate = acCoDate;
	}

}