package com.pg.model;

public class Notification {

	private String id;
	private String title;
	private String messageBody;
	private String button1;
	private String button2;
	private String button3;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	public String getButton1() {
		return button1;
	}
	public void setButton1(String button1) {
		this.button1 = button1;
	}
	public String getButton2() {
		return button2;
	}
	public void setButton2(String button2) {
		this.button2 = button2;
	}
	public String getButton3() {
		return button3;
	}
	public void setButton3(String button3) {
		this.button3 = button3;
	}
	public void clear() {
		this.id="";
		this.title="";
		this.messageBody="";
		this.button1="";
		this.button2="";
		this.button3="";
	}
	
	
}
