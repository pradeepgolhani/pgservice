package com.pg.util;

import java.util.HashMap;
import java.util.Map;


public class Message {
	private String token;
	private Map<String, String> data = new HashMap<String, String>();
	
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
