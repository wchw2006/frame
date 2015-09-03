package com.tja.frame.core.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tja.frame.common.orm.MyJpaRepository;
import com.tja.frame.core.domain.User;

@Repository
public interface UserDao extends MyJpaRepository<User, Integer> {

	public User findByUserName(String userName);
	
	public List<User> findByOrganizationId(Integer orgId);
	
	public void deleteByUserName(String name);
}
