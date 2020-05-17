package com.xmlg.ctc.entity;

public class ActiveJoin {
	private int actJoinId;
	private int actId;
	private String joinUserid;
	private String joinPicture;

	public ActiveJoin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActiveJoin(int actId, String joinUserid, String joinPicture) {
		super();
		this.actId = actId;
		this.joinUserid = joinUserid;
		this.joinPicture = joinPicture;
	}

	public int getActJoinId() {
		return actJoinId;
	}

	public void setActJoinId(int actJoinId) {
		this.actJoinId = actJoinId;
	}

	public int getActId() {
		return actId;
	}

	public void setActId(int actId) {
		this.actId = actId;
	}

	public String getJoinUserid() {
		return joinUserid;
	}

	public void setJoinUserid(String joinUserid) {
		this.joinUserid = joinUserid;
	}

	public String getJoinPicture() {
		return joinPicture;
	}

	public void setJoinPicture(String joinPicture) {
		this.joinPicture = joinPicture;
	}

}
