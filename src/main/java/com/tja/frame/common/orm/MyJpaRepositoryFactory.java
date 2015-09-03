package com.tja.frame.common.orm;

import static org.springframework.data.querydsl.QueryDslUtils.QUERY_DSL_PRESENT;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryMetadata;


/**
 *  the user-defined MyJpaRepositoryFactory
 *  
 * @author xiaoxin
 *
 */
public class MyJpaRepositoryFactory extends JpaRepositoryFactory {

	public MyJpaRepositoryFactory(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(
			RepositoryMetadata metadata, EntityManager entityManager) {
		Class<?> repositoryInterface = metadata.getRepositoryInterface();
		JpaEntityInformation<?, Serializable> entityInformation = getEntityInformation(metadata
				.getDomainType());
		@SuppressWarnings({ "unchecked", "rawtypes" })
		SimpleJpaRepository<?, ?> repo = isQueryDslExecutor(repositoryInterface) ? new MyQueryDslJpaRepository(
				entityInformation, entityManager) : new MySimpleJpaRepository(
				entityInformation, entityManager);
		
		return repo;
	}

	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
		if (isQueryDslExecutor(metadata.getRepositoryInterface())) {
			return QueryDslJpaRepository.class;
		} else {
			return MySimpleJpaRepository.class;
		}
	}

	private boolean isQueryDslExecutor(Class<?> repositoryInterface) {
		return QUERY_DSL_PRESENT
				&& MyQueryDslPredicateExecutor.class
						.isAssignableFrom(repositoryInterface);
	}
}
