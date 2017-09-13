package com.sopra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="admin")
@PrimaryKeyJoinColumn(name="ADM_ID", referencedColumnName="PER_ID")
public class Admin extends Personne {
	private static final long serialVersionUID = 1L;

	// Attributs
	@Column(name="ADM_PSEUDO")
	protected String pseudo;
	
	@Column(name="ADM_MDP")
	protected String mdp;

	
	
	// Getters & Setters
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
