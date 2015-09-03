package com.tja.frame.common.orm;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyJpaRepository<T,ID extends Serializable> extends JpaRepository<T, ID> {
 
	List<T>  findAll(Limitable limitable);
}
