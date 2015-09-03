package com.tja.frame.core.repository;

import org.springframework.stereotype.Repository;

import com.tja.frame.common.orm.MyJpaRepository;
import com.tja.frame.core.domain.UserRole;

@Repository
public interface UserRoleDao extends MyJpaRepository<UserRole, Integer> {

}
