package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.ICandidatDAO;
import com.sopra.model.Candidat;

@Repository
@Transactional
public class CandidatHibernateDAO implements ICandidatDAO {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Candidat> findAll() {
		try {
			return (List<Candidat>)em.createQuery("FROM Candidat").getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Candidat find(int id) {
		try {
			return em.find(Candidat.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Candidat save(Candidat candidat) {
		return em.merge(candidat);
	}

	@Override
	public void delete(Candidat candidat) {
		em.remove(em.merge(candidat));
	}

}
