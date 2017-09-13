package com.sopra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin extends Personne {

	
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
