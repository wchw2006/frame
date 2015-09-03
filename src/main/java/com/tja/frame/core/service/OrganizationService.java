package com.tja.frame.core.service;

import java.util.List;

import com.tja.frame.core.domain.User;

public interface OrganizationService {

	List<User> findAllUsersByOrgId(Integer id);
	
}
