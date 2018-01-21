package com.pg.service;


import java.io.UnsupportedEncodingException;
import java.util.Base64;

import com.pg.model.Login;
import com.pg.model.User;
import com.pg.util.Constants;

public class UserService implements IUserService{
	
	
	public User validateUser(Login login) {

		User user = null;
		byte[] asBytes = Base64.getDecoder().decode(Constants.PASS);
		if (login.getUsername().equals("pg")
				&& new String(asBytes).equals(login.getPassword())) {
			user = new User();
			user.setUsername("pg");
			user.setFirstname("Pradeep");
		}

		return user;
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] asBytes = Base64.getDecoder().decode(Constants.PASS);
		System.out.println(new String(asBytes));
	}
	
}
