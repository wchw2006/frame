package com.tja.frame.core.repository;

import org.springframework.stereotype.Repository;

import com.tja.frame.common.orm.MyJpaRepository;
import com.tja.frame.core.domain.Role;

@Repository
public interface RoleDao extends MyJpaRepository<Role, Integer> {

}
