package com.tja.frame.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tja.frame.core.domain.User;
import com.tja.frame.core.repository.UserDao;
import com.tja.frame.core.service.UserService;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;
	
	@Override
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public void updatePassword(String userName, String password) {
		User user = userDao.findByUserName(userName);
		user.setPassword(password);
		userDao.save(user);
	}

}
