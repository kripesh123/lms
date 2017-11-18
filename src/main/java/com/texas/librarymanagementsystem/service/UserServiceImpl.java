package com.texas.librarymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texas.librarymanagementsystem.dao.UserDAO;
import com.texas.librarymanagementsystem.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDao;
	
	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
