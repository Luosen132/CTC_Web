package com.xmlg.ctc.entity;



public class Talk {

	// Fields

	private int TId;
	private String TName;
	private String user;
	public Talk(String tName, String user, String tText, String tTime) {
		super();
		TName = tName;
		this.user = user;
		TText = tText;
		TTime = tTime;
	}

	private String TText;
	private String TPicture;
	private String TTime;
	
	
	
	
	
	public Talk(String user, String tText, String tTime) {
		super();
		this.user = user;
		TText = tText;
		TTime = tTime;
	}




	// Constructors

	/** default constructor */
	public Talk() {
	}




	// Property accessors

	public int getTId() {
		return this.TId;
	}

	public void setTId(int TId) {
		this.TId = TId;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTName() {
		return this.TName;
	}

	public void setTName(String TName) {
		this.TName = TName;
	}

	public String getTText() {
		return this.TText;
	}

	public void setTText(String TText) {
		this.TText = TText;
	}

	public String getTPicture() {
		return this.TPicture;
	}

	public void setTPicture(String TPicture) {
		this.TPicture = TPicture;
	}

	public String getTTime() {
		return this.TTime;
	}

	public void setTTime(String TTime) {
		this.TTime = TTime;
	}


}