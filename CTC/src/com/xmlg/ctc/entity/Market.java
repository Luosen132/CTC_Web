package com.xmlg.ctc.entity;



public class Market {

	// Fields

	private int MId;
	private String user;
	private String MName;
	private double MPrice;
	private String MState;
	private String MPhoto;
	private String MTime;
	private String Mphone;

	// Constructors

	/** default constructor */
	public Market() {
	}

	/** full constructor */
	public Market(String user, String MName, double MPrice, String MState,
			String MPhoto, String MTime,String Mphone) {
		this.user = user;
		this.MName = MName;
		this.MPrice = MPrice;
		this.MState = MState;
		this.MPhoto = MPhoto;
		this.MTime = MTime;
		this.Mphone=Mphone;
	}

	// Property accessors

	public int getMId() {
		return this.MId;
	}

	public void setMId(int MId) {
		this.MId = MId;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMName() {
		return this.MName;
	}

	public void setMName(String MName) {
		this.MName = MName;
	}

	public double getMPrice() {
		return this.MPrice;
	}

	public void setMPrice(double MPrice) {
		this.MPrice = MPrice;
	}

	public String getMState() {
		return this.MState;
	}

	public void setMState(String MState) {
		this.MState = MState;
	}

	public String getMPhoto() {
		return this.MPhoto;
	}

	public void setMPhoto(String MPhoto) {
		this.MPhoto = MPhoto;
	}

	public String getMTime() {
		return this.MTime;
	}

	public void setMTime(String MTime) {
		this.MTime = MTime;
	}

	public String getMphone() {
		return Mphone;
	}

	public void setMphone(String mphone) {
		Mphone = mphone;
	}

}