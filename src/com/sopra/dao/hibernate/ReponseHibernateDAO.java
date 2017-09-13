package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IReponseDAO;
import com.sopra.model.Proposition;
import com.sopra.model.Reponse;

@Repository
@Transactional
public class ReponseHibernateDAO implements IReponseDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Reponse> findAll() {
		try {
			return (List<Reponse>)em.createQuery("FROM Reponse").getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Reponse find(int id) {
		try {
			return em.find(Reponse.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Reponse save(Reponse reponse) {
		return em.merge(reponse);
	}

	@Override
	public void delete(Reponse reponse) {
		em.remove(em.merge(reponse));
		
	}
	

	
	
}
