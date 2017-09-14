package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.ICandidatTestDAO;
import com.sopra.model.CandidatTest;

@Repository
@Transactional
public class CandidatTestHibernateDAO implements ICandidatTestDAO {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<CandidatTest> findAll() {
		try {
			return (List<CandidatTest>)em.createQuery("FROM CandidatTest").getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public CandidatTest find(int id) {
		try {
			return em.find(CandidatTest.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public CandidatTest save(CandidatTest candidatTest) {
		return em.merge(candidatTest);
	}

	@Override
	public void delete(CandidatTest candidatTest) {
		em.remove(em.merge(candidatTest));
	}

	@Override
	public CandidatTest findByCode(String code) {
		try {
			return (CandidatTest)em.createQuery("FROM CandidatTest c WHERE c.code = '" + code + "'").getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
