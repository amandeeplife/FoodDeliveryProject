package com.edu.dao.impl;

 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.edu.dao.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	protected Class<T> daoType;
	
	public void setDaoType(Class<T> daoType) {
		this.daoType = daoType;
	}

	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		entityManager.persist(t);
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		T t = findOne(id);
		delete(t);
	}

	@Override
	public T findOne(String id) {
		// TODO Auto-generated method stub
		return (T) entityManager.find(daoType, id);
	}

	@Override
	public T findOne(Long id) {
		// TODO Auto-generated method stub
		return (T) entityManager.find(daoType, id);
	}

	@Override
	public T update(T t) {
		// TODO Auto-generated method stub
		return (T) entityManager.merge(t);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from " + daoType.getName()).getResultList();
	}
	
	
}
