package com.tja.frame.common.orm;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/**
 * JPA Repository 工厂类
 * 
 * @author xiaoxin
 * 
 * @param <T>
 * @param <S>
 * @param <ID>
 */
public class MyJpaRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable>
		extends JpaRepositoryFactoryBean<T, S, ID> {
	protected RepositoryFactorySupport createRepositoryFactory(
			EntityManager entityManager) {
		return new MyJpaRepositoryFactory(entityManager);
	}
}
