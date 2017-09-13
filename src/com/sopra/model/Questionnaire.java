package com.sopra.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Questionnaire implements Serializable {
	//pour enlever les erreurs jaunes qu'on peut enlever
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="QNR_ID")
	private Integer id;
	
	@Column(name="QNR_NOM")
	private String nom;
	
	@OneToMany(mappedBy="questionnaire")
	private List<Question> questions;
	
}
