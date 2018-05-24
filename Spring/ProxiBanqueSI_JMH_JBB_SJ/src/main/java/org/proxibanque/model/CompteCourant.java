package org.proxibanque.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Classe représentant les comptes Courants de la société Proxibanque
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
@Entity
public class CompteCourant extends Compte {

	private double decouvert = -1000;

	@OneToOne(cascade = { CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "carte_id")
	private Carte carte;

	// *** Constructor ***
	public CompteCourant() {
		super();
	}

	public CompteCourant(String numero, String date) {
		super(numero, date);
	}

	// *** Getters & Setters
	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	// *** Methods ***
	@Override
	public String toString() {
		return super.toString();
	}

}
