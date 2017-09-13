package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IPropositionDAO;
import com.sopra.model.Proposition;
import com.sopra.model.Question;

@Repository
@Transactional
public class PropositionHibernateDAO implements IPropositionDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Proposition> findAll() {
		try {
			return (List<Proposition>)em.createQuery("FROM Proposition").getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Proposition find(int id) {
		try {
			return em.find(Proposition.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Proposition save(Proposition proposition) {
		return em.merge(proposition);
	}

	@Override
	public void delete(Proposition proposition) {
		em.remove(em.merge(proposition));
	}
}
