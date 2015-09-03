package com.tja.frame.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tja.frame.core.domain.Organization;
import com.tja.frame.core.domain.User;
import com.tja.frame.core.repository.OrganizationDao;
import com.tja.frame.core.service.OrganizationService;

@Service
@Transactional(readOnly = true)
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationDao organizationDao;
	
	@Override
	public List<User> findAllUsersByOrgId(Integer id) {
		Organization org = organizationDao.findOne(id);
		return org.getUsers();
	}

}
