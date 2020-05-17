package com.xmlg.ctc.entity;

public class Notice {
private int not_id;
private String not_title;
private String not_content;
private String not_time;
public Notice(int notId, String notTitle, String notContent, String notTime) {
	super();
	not_id = notId;
	not_title = notTitle;
	not_content = notContent;
	not_time = notTime;
}


public Notice(String notTitle, String notContent, String notTime) {
	super();
	not_title = notTitle;
	not_content = notContent;
	not_time = notTime;
}

public Notice() {
	super();
	// TODO Auto-generated constructor stub
}
public int getNot_id() {
	return not_id;
}
public void setNot_id(int notId) {
	not_id = notId;
}
public String getNot_title() {
	return not_title;
}
public void setNot_title(String notTitle) {
	not_title = notTitle;
}
public String getNot_content() {
	return not_content;
}
public void setNot_content(String notContent) {
	not_content = notContent;
}
public String getNot_time() {
	return not_time;
}
public void setNot_time(String notTime) {
	not_time = notTime;
}

}
