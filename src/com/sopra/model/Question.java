package com.sopra.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="question")
public class Question implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="QUE_ID")
	private int id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="QUE_QUESTIONNAIRE")
	private Questionnaire questionnaire;
	
	@Column(name="QUE_LIBELLE")
	@NotNull
	@NotEmpty(message="Veuillez renseigner un libellé")
	private String libelle;

	@Column(name="QUE_PROPOSITIONS")
	@OneToMany(mappedBy="question")
	private List<Proposition> propositions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Proposition> getPropositions() {
		return propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}
	
	
	
}
