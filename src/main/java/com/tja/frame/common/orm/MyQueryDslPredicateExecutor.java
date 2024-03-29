package com.tja.frame.common.orm;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.mysema.query.types.Predicate;

/**
 *  QueryDsl Predicate Executor
 *  
 * @author xiaoxin
 *
 * @param <T>
 */
public interface MyQueryDslPredicateExecutor<T> extends
		QueryDslPredicateExecutor<T> {

	List<T> findAll(Predicate predicate, Sort sort);

	List<T> findAll(Predicate predicate, Limitable limitable);
}
