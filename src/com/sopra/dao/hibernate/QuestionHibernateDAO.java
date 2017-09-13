package com.sopra.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.dao.IQuestionDAO;
import com.sopra.model.Question;
import com.sopra.model.Questionnaire;

@Repository
@Transactional
public class QuestionHibernateDAO implements IQuestionDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAll() {
		try {
			return (List<Question>)em.createQuery("FROM Question").getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Question find(int id) {
		try {
			return em.find(Question.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Question save(Question question) {
		return em.merge(question);
	}

	@Override
	public void delete(Question question) {
		em.remove(em.merge(question));

	}
}

