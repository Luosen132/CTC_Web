package com.xmlg.ctc.entity;

public class TalkComment  {

	// Fields

	private int tcId;
	private int tcTid;
	private String userNo;
	private String tcText;
	private String tcTime;
	

	public TalkComment(int tcTid, String userNo, String tcText, String tcTime) {
		super();
		this.tcTid = tcTid;
		this.userNo = userNo;
		this.tcText = tcText;
		this.tcTime = tcTime;
	}

	public int getTcTid() {
		return tcTid;
	}

	public void setTcTid(int tcTid) {
		this.tcTid = tcTid;
	}


	// Constructors

	/** default constructor */
	public TalkComment() {
	}

	/** full constructor */

	// Property accessors

	public int getTcId() {
		return this.tcId;
	}

	public void setTcId(int tcId) {
		this.tcId = tcId;
	}


	public String getUser() {
		return this.userNo;
	}

	public void setUser(String userNo) {
		this.userNo = userNo;
	}

	public String getTcText() {
		return this.tcText;
	}

	public void setTcText(String tcText) {
		this.tcText = tcText;
	}

	public String getTcTime() {
		return this.tcTime;
	}

	public void setTcTime(String tcTime) {
		this.tcTime = tcTime;
	}

}