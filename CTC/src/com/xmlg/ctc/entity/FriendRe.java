package com.xmlg.ctc.entity;


public class FriendRe  {

	// Fields

	private int reId;
	private String userByReNo;
	private String userByReStuno;
	private int reOperation;
	private String reTime;

	// Constructors	

	/** default constructor */
	public FriendRe() {
	}

	/** full constructor */
	public FriendRe(String userByReNo, String userByReStuno, int reOperation,
			String reTime) {
		this.userByReNo = userByReNo;
		this.userByReStuno = userByReStuno;
		this.reOperation = reOperation;
		this.reTime = reTime;
	}

	// Property accessors

	public int getReId() {
		return this.reId;
	}

	public void setReId(int reId) {
		this.reId = reId;
	}

	public String getStringByReNo() {
		return this.userByReNo;
	}

	public void setStringByReNo(String userByReNo) {
		this.userByReNo = userByReNo;
	}

	public String getStringByReStuno() {
		return this.userByReStuno;
	}

	public void setStringByReStuno(String userByReStuno) {
		this.userByReStuno = userByReStuno;
	}

	public int getReOperation() {
		return this.reOperation;
	}

	public void setReOperation(int reOperation) {
		this.reOperation = reOperation;
	}

	public String getReTime() {
		return this.reTime;
	}

	public void setReTime(String reTime) {
		this.reTime = reTime;
	}

}