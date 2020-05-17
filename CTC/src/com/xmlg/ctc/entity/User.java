package com.xmlg.ctc.entity;


public class User {

	// Fields

	private String UNo;
	private String hobby;
	private String UName;
	private String URealname;
	private String UPassword;
	private String UPicture;
	private int USchool;
	private int UCollege;
	private String UIdcard;
	private String USex;
	private String UPhone;
	private String UPersonality;
	private String UCensus;
	private int USingle;
	private int UDispark;
	private int Ustate;
	private int UCqcId;

	// Constructors

	/** default constructor */
	public User() {
	}


	public User(String uNo, String uPicture) {
		super();
		UNo = uNo;
		UPicture = uPicture;
	}


	public User(String uNo, String uName, String uRealname, String uPassword,
			int uSchool, int uCollege) {
		super();
		UNo = uNo;
		UName = uName;
		URealname = uRealname;
		UPassword = uPassword;
		USchool = uSchool;
		UCollege = uCollege;
	}
	
	
	public User(String uNo,String hobby, String uName, int uSchool, int uCollege,
			String uSex, String uPersonality, String uCensus, int uSingle) {
		super();
		UNo = uNo;
		this.hobby = hobby;
		UName = uName;
		USchool = uSchool;
		UCollege = uCollege;
		USex = uSex;
		UPersonality = uPersonality;
		UCensus = uCensus;
		USingle = uSingle;
	}


	public User(String uNo, String uName, String uRealname, String uPassword,
			int uSchool, int uCollege, String uIdcard) {
		super();
		UNo = uNo;
	
		UName = uName;
		URealname = uRealname;
		UPassword = uPassword;
		USchool = uSchool;
		UCollege = uCollege;
		UIdcard = uIdcard;
	}


	public User(String uName, String uRealname, String uPassword, int uSchool,
			int uCollege, String uIdcard) {
		super();
		UName = uName;
		URealname = uRealname;
		UPassword = uPassword;
		USchool = uSchool;
		UCollege = uCollege;
		UIdcard = uIdcard;
	}
	
	


	public User(String uNo, String hobby, String uName, String uRealname,
			String uPassword, String uPicture, int uSchool, int uCollege,
			String uIdcard, String uSex, String uPhone, String uPersonality,
			String uCensus, int uSingle, int uDispark, int ustate) {
		super();
		UNo = uNo;
		this.hobby = hobby;
		UName = uName;
		URealname = uRealname;
		UPassword = uPassword;
		UPicture = uPicture;
		USchool = uSchool;
		UCollege = uCollege;
		UIdcard = uIdcard;
		USex = uSex;
		UPhone = uPhone;
		UPersonality = uPersonality;
		UCensus = uCensus;
		USingle = uSingle;
		UDispark = uDispark;
		Ustate = ustate;
	}


	// Property accessors

	public String getUNo() {
		return this.UNo;
	}

	public int getUCqcId() {
		return UCqcId;
	}


	public void setUCqcId(int uCqcId) {
		UCqcId = uCqcId;
	}


	public void setUNo(String UNo) {
		this.UNo = UNo;
	}



	public String getHobby() {
		return this.hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	public String getURealname() {
		return this.URealname;
	}

	public void setURealname(String URealname) {
		this.URealname = URealname;
	}

	public String getUPassword() {
		return this.UPassword;
	}

	public void setUPassword(String UPassword) {
		this.UPassword = UPassword;
	}

	public String getUPicture() {
		return this.UPicture;
	}

	public void setUPicture(String UPicture) {
		this.UPicture = UPicture;
	}

	public int getUSchool() {
		return this.USchool;
	}

	public void setUSchool(int USchool) {
		this.USchool = USchool;
	}

	public int getUCollege() {
		return this.UCollege;
	}

	public void setUCollege(int UCollege) {
		this.UCollege = UCollege;
	}

	public String getUIdcard() {
		return this.UIdcard;
	}

	public void setUIdcard(String UIdcard) {
		this.UIdcard = UIdcard;
	}

	public String getUSex() {
		return this.USex;
	}

	public void setUSex(String USex) {
		this.USex = USex;
	}

	public String getUPhone() {
		return this.UPhone;
	}

	public void setUPhone(String UPhone) {
		this.UPhone = UPhone;
	}

	public String getUPersonality() {
		return this.UPersonality;
	}

	public void setUPersonality(String UPersonality) {
		this.UPersonality = UPersonality;
	}

	public String getUCensus() {
		return this.UCensus;
	}

	public void setUCensus(String UCensus) {
		this.UCensus = UCensus;
	}

	public int getUSingle() {
		return this.USingle;
	}

	public void setUSingle(int USingle) {
		this.USingle = USingle;
	}

	public int getUDispark() {
		return this.UDispark;
	}

	public void setUDispark(int UDispark) {
		this.UDispark = UDispark;
	}

	public int getUstate() {
		return Ustate;
	}

	public void setUstate(int ustate) {
		Ustate = ustate;
	}



}