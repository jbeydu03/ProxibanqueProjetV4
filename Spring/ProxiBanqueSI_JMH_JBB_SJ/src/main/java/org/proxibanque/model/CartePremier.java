package org.proxibanque.model;

import javax.persistence.Entity;

/**
 * Classe représentant les cartes Premiers des clients de la société Proxibanque
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
@Entity
public class CartePremier extends Carte {

	// *** Constructor ***
	public CartePremier() {
		super();
	}

	// *** Methods ***
	@Override
	public String toString() {
		return "Carte Premier";
	}
}
