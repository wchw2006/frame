package com.tja.frame.core.service;

import com.tja.frame.core.domain.User;

public interface UserService {
	
	User findByUserName(String userName);
	
	void updatePassword(String userName,String password);
}
