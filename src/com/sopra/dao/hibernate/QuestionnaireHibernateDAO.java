package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IQuestionnaireDAO;
import com.sopra.model.Admin;
import com.sopra.model.Questionnaire;
import com.sopra.model.Test;

@Repository
@Transactional
public class QuestionnaireHibernateDAO implements IQuestionnaireDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Questionnaire> findAll() {
		try {
			return (List<Questionnaire>)em.createQuery("FROM Questionnaire").getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Questionnaire find(int id) {
		try {
			return em.find(Questionnaire.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Questionnaire save(Questionnaire questionnaire) {
		return em.merge(questionnaire);
	}

	@Override
	public void delete(Questionnaire questionnaire) {
		em.remove(em.merge(questionnaire));
	}
	
	
	
}
