package com.tma.repo;


import java.util.List;

import org.springframework.cglib.core.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tma.model.Music;

public interface QueryDslPredicateExecutor<T> {
	T findOne(Predicate predicate);

	List<T> findAll(Predicate predicate);

	//List<T> findAll(Predicate predicate, OrderSpecifier<?>... orders);

	Page<T> findAll(List<Music> listMusic, Pageable pageable);

	Long count(Predicate predicate);
}
