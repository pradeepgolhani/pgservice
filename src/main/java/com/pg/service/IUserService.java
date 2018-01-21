package com.pg.service;

import com.pg.model.Login;
import com.pg.model.User;

public interface IUserService {

	User validateUser(Login login);

}
