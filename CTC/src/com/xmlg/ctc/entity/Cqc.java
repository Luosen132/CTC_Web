package com.xmlg.ctc.entity;

public class Cqc  {

	// Fields

	private int cqcId;
	private String stuid;
	private String cqcTel;
	private String cqcBirthday;
	private String cqcAddress;
	private int singleState;
	private String cqcEmail;
	private String cqcPicture;
	private int cqcNum;

	// Constructors

	/** default constructor */
	public Cqc() {
	}
	

	public Cqc(int cqcId, String stuid, String cqcTel, String cqcBirthday,
			String cqcAddress, int singleState, String cqcEmail,
			String cqcPicture, int cqcNum) {
		super();
		this.cqcId = cqcId;
		this.stuid = stuid;
		this.cqcTel = cqcTel;
		this.cqcBirthday = cqcBirthday;
		this.cqcAddress = cqcAddress;
		this.singleState = singleState;
		this.cqcEmail = cqcEmail;
		this.cqcPicture = cqcPicture;
		this.cqcNum = cqcNum;
	}
	


	public Cqc(String stuid, String cqcTel, String cqcBirthday,
			String cqcAddress, int singleState, String cqcEmail,
			String cqcPicture, int cqcNum) {
		super();
		this.stuid = stuid;
		this.cqcTel = cqcTel;
		this.cqcBirthday = cqcBirthday;
		this.cqcAddress = cqcAddress;
		this.singleState = singleState;
		this.cqcEmail = cqcEmail;
		this.cqcPicture = cqcPicture;
		this.cqcNum = cqcNum;
	}


	public int getCqcId() {
		return cqcId;
	}

	public void setCqcId(int cqcId) {
		this.cqcId = cqcId;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public String getCqcTel() {
		return cqcTel;
	}

	public void setCqcTel(String cqcTel) {
		this.cqcTel = cqcTel;
	}

	public String getCqcBirthday() {
		return cqcBirthday;
	}

	public void setCqcBirthday(String cqcBirthday) {
		this.cqcBirthday = cqcBirthday;
	}

	public String getCqcAddress() {
		return cqcAddress;
	}

	public void setCqcAddress(String cqcAddress) {
		this.cqcAddress = cqcAddress;
	}

	public int getSingleState() {
		return singleState;
	}

	public void setSingleState(int singleState) {
		this.singleState = singleState;
	}

	public String getCqcEmail() {
		return cqcEmail;
	}

	public void setCqcEmail(String cqcEmail) {
		this.cqcEmail = cqcEmail;
	}

	public String getCqcPicture() {
		return cqcPicture;
	}

	public void setCqcPicture(String cqcPicture) {
		this.cqcPicture = cqcPicture;
	}

	public int getCqcNum() {
		return cqcNum;
	}

	public void setCqcNum(int cqcNum) {
		this.cqcNum = cqcNum;
	}

	/** full constructor */
	

}