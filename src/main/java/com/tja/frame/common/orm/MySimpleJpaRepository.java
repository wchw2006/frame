package com.tja.frame.common.orm;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;


public class MySimpleJpaRepository<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements
		MyJpaRepository<T, ID>,MyJpaSpecificationExecutor<T> {
     
	private JpaEntityInformation entityInformation;
	
	private EntityManager em;
	
	private CrudMethodMetadata metadata;
	
	public MySimpleJpaRepository(JpaEntityInformation<T, ?> entityInformation,
			EntityManager em) {
		super(entityInformation, em);
		this.entityInformation = entityInformation;
		this.em = em;
	}

	public List<T> findAll(Limitable limitable) {
		if (limitable != null) {
			TypedQuery<T> query = getQuery(null, limitable.getSort());
			Integer firstResult = limitable.getFirstResult();
			if (firstResult != null && firstResult > 0) {
				query.setFirstResult(firstResult);
			}
			Integer maxResults = limitable.getMaxResults();
			if (maxResults != null && maxResults > 0) {
				query.setMaxResults(maxResults);
			}
			return query.getResultList();
		} else {
			return findAll();
		}
	}

	public List<T> findAll(Specification<T> spec, Limitable limitable) {
		if (limitable != null) {
			TypedQuery<T> query = getQuery(spec, limitable.getSort());
			if (limitable.getFirstResult() != null) {
				query.setFirstResult(limitable.getFirstResult());
			}
			if (limitable.getMaxResults() != null) {
				query.setMaxResults(limitable.getMaxResults());
			}
			return query.getResultList();
		} else {
			return findAll(spec);
		}
	}
}
