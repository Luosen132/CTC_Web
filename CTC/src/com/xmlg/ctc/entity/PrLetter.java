package com.xmlg.ctc.entity;


public class PrLetter {

	// Fields

	private int prId;
	private int friend;
	private String prMessage;
	private String prTime;
	private int prState;
	// Constructors

	/** default constructor */
	public PrLetter() {
	}

	/** full constructor */
	public PrLetter(int friend, String prMessage, String prTime,int prState) {
		this.friend = friend;
		this.prMessage = prMessage;
		this.prTime = prTime;
		this.prState = prState;
	}
	

	public PrLetter( int friend, String prMessage, String prTime) {
		super();
		this.friend = friend;
		this.prMessage = prMessage;
		this.prTime = prTime;
	}

	// Property accessors

	public int getPrId() {
		return this.prId;
	}

	public int getPrState() {
		return prState;
	}

	public void setPrState(int prState) {
		this.prState = prState;
	}

	public void setPrId(int prId) {
		this.prId = prId;
	}

	public int getFriend() {
		return this.friend;
	}

	public void setFriend(int friend) {
		this.friend = friend;
	}

	public String getPrMessage() {
		return this.prMessage;
	}

	public void setPrMessage(String prMessage) {
		this.prMessage = prMessage;
	}

	public String getPrTime() {
		return this.prTime;
	}

	public void setPrTime(String prTime) {
		this.prTime = prTime;
	}

}