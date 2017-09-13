package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.ITestDAO;
import com.sopra.model.Admin;
import com.sopra.model.Test;

@Repository
@Transactional
public class TestHibernateDAO implements ITestDAO {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Test> findAll() {
		try {
			return (List<Test>)em.createQuery("FROM Test").getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Test find(int id) {
		try {
			return em.find(Test.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Test save(Test test) {
		return em.merge(test);
	}

	@Override
	public void delete(Test test) {
		em.remove(em.merge(test));
	}

	
}
