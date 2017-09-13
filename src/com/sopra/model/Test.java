package com.sopra.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Test")
public class Test implements Serializable{
	//pour enlever les erreurs jaunes qu'on peut enlever
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TES_ID")
	private Integer id;
	
	@Column(name="TES_NIVEAU")
	private String niveau;
	
	@Column(name="TES_BRANCHE")
	private String branche;
	
	@ManyToMany(mappedBy="tests")
	private List<Questionnaire> questionnaires;
	
	//getters and setters
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the niveau
	 */
	public String getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau the niveau to set
	 */
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	/**
	 * @return the branche
	 */
	public String getBranche() {
		return branche;
	}

	/**
	 * @param branche the branche to set
	 */
	public void setBranche(String branche) {
		this.branche = branche;
	}

	/**
	 * @return the questionnaires
	 */
	public List<Questionnaire> getQuestionnaires() {
		return questionnaires;
	}

	/**
	 * @param questionnaires the questionnaires to set
	 */
	public void setQuestionnaires(List<Questionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}

	
	
}
