package org.proxibanque.model;

import javax.persistence.Entity;

/**
 * Classe représentant les comptes Epargnes de la société Proxibanque
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
@Entity
public class CompteEpargne extends Compte {

	private double taux = 0.03;

	// *** Constructor ***
	public CompteEpargne() {
		super();
	}

	// *** Getters & Setters
	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	// *** Methods ***
	@Override
	public String toString() {
		return " [" + taux + "]";
	}

}
