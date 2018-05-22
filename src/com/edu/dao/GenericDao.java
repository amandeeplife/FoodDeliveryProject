package com.edu.dao;

import java.util.List;

public interface GenericDao<T> {
	void save(T t);
	
	void delete(T t);
	
	void delete(Long id);
	
	T findOne(String id);
	
	T findOne(Long id);
	
	T update(T t);
	
	List<T> findAll();
	
}
