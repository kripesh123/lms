package com.texas.librarymanagementsystem.service;

import com.texas.librarymanagementsystem.entity.User;

public interface UserService {
	
	User findByUsername(String username);

}
