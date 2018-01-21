package com.pg.service;

import org.apache.tomcat.util.codec.binary.Base64;

import com.pg.model.Login;
import com.pg.model.User;
import com.pg.util.Constants;

public class UserService implements IUserService{
	
	
	public User validateUser(Login login) {
		byte[] encodedBytes = Base64.decodeBase64(Constants.PASS.getBytes());
		User user = null;
		if(login.getUsername().equals("pg") && new String(encodedBytes).equals(login.getPassword())){
			user = new User();
			user.setUsername("pg");
			user.setFirstname("Pradeep");
		}
		return user;
	}
	
}
