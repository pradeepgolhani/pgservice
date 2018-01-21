package com.pg.service;


import java.io.UnsupportedEncodingException;
import java.util.Base64;

import com.pg.model.Login;
import com.pg.model.User;
import com.pg.util.Constants;

public class UserService implements IUserService{
	
	
	public User validateUser(Login login) {
		
		String asB64;
		User user = null;
		try {
			asB64 = Base64.getEncoder().encodeToString(Constants.PASS.getBytes("utf-8"));
			if(login.getUsername().equals("pg") && new String(asB64).equals(login.getPassword())){
				user = new User();
				user.setUsername("pg");
				user.setFirstname("Pradeep");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return user;
	}
	
}
