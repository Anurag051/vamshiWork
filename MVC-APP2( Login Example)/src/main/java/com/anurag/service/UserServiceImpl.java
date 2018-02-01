package com.anurag.service;

import com.anurag.dao.UserDAO;
import com.anurag.domain.Login;

public class UserServiceImpl implements UserService{
	
	private UserDAO userDao;

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public Login login(Login login) {
		login=userDao.login(login);
		return login;
	}
	
	

}
