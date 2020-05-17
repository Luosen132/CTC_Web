package com.xmlg.ctc.entity;



public class Academic {

	// Fields

	private int ac_id;
	private String acNo;
	private String acHeadline;
	private String acContent;
	private String acFile;
	private String acDate;
	private int acCheck;
	
	public int getAcCheck() {
		return acCheck;
	}
	public void setAcCheck(int acCheck) {
		this.acCheck = acCheck;
	}
	public int getAc_id() {
		return ac_id;
	}
	public void setAc_id(int acId) {
		ac_id = acId;
	}
	public String getAc_no() {
		return acNo;
	}
	public void setAc_no(String acNo) {
		this.acNo = acNo;
	}
	public String getAcHeadline() {
		return acHeadline;
	}
	public void setAcHeadline(String acHeadline) {
		this.acHeadline = acHeadline;
	}
	public String getAcContent() {
		return acContent;
	}
	public void setAcContent(String acContent) {
		this.acContent = acContent;
	}
	public String getAcFile() {
		return acFile;
	}
	public void setAcFile(String acFile) {
		this.acFile = acFile;
	}
	public String getAcDate() {
		return acDate;
	}
	public void setAcDate(String acDate) {
		this.acDate = acDate;
	}
	public Academic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Academic(int acId, String acNo, String acHeadline, String acContent,
			String acDate) {
		super();
		ac_id = acId;
		this.acNo = acNo;
		this.acHeadline = acHeadline;
		this.acContent = acContent;
		this.acDate = acDate;
	}
	public Academic(int acId, String acNo, String acHeadline, String acContent,
			String acFile, String acDate) {
		super();
		ac_id = acId;
		this.acNo = acNo;
		this.acHeadline = acHeadline;
		this.acContent = acContent;
		this.acFile = acFile;
		this.acDate = acDate;
	}
	
	

}