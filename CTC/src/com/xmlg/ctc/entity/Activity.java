package com.xmlg.ctc.entity;

public class Activity  {

	// Fields

	private int actId;
	private String actPerid;
	private String actTitle;
	private String actType;
	private String actContent;
	private String actTime;
	private int actMaxnum;
	private int actNum;
	private int actCheck;

	// Constructors

	/** default constructor */
	public Activity() {
	}

	public Activity(int actId, String actPerid, String actTitle,
			String actType, String actContent, String actTime, int actMaxnum,
			int actNum, int actCheck) {
		super();
		this.actId = actId;
		this.actPerid = actPerid;
		this.actTitle = actTitle;
		this.actType = actType;
		this.actContent = actContent;
		this.actTime = actTime;
		this.actMaxnum = actMaxnum;
		this.actNum = actNum;
		this.actCheck = actCheck;
	}

	public Activity(String actPerid, String actTitle, String actType,
			String actContent, String actTime, int actMaxnum, int actNum,
			int actCheck) {
		super();
		this.actPerid = actPerid;
		this.actTitle = actTitle;
		this.actType = actType;
		this.actContent = actContent;
		this.actTime = actTime;
		this.actMaxnum = actMaxnum;
		this.actNum = actNum;
		this.actCheck = actCheck;
	}

	public int getActId() {
		return actId;
	}

	public void setActId(int actId) {
		this.actId = actId;
	}

	public String getActPerid() {
		return actPerid;
	}

	public void setActPerid(String actPerid) {
		this.actPerid = actPerid;
	}

	public String getActTitle() {
		return actTitle;
	}

	public void setActTitle(String actTitle) {
		this.actTitle = actTitle;
	}

	public String getActType() {
		return actType;
	}

	public void setActType(String actType) {
		this.actType = actType;
	}

	public String getActContent() {
		return actContent;
	}

	public void setActContent(String actContent) {
		this.actContent = actContent;
	}

	public String getActTime() {
		return actTime;
	}

	public void setActTime(String actTime) {
		this.actTime = actTime;
	}

	public int getActMaxnum() {
		return actMaxnum;
	}

	public void setActMaxnum(int actMaxnum) {
		this.actMaxnum = actMaxnum;
	}

	public int getActNum() {
		return actNum;
	}

	public void setActNum(int actNum) {
		this.actNum = actNum;
	}

	public int getActCheck() {
		return actCheck;
	}

	public void setActCheck(int actCheck) {
		this.actCheck = actCheck;
	}



}