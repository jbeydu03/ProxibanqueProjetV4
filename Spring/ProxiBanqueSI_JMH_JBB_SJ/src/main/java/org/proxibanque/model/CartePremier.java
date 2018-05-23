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

	public CartePremier(long id, String numero, boolean active) {
		super(id, numero, active);
		// TODO Auto-generated constructor stub
	}

	public CartePremier(String numero) {
		super(numero);
		// TODO Auto-generated constructor stub
	}

	// *** Methods ***
	@Override
	public String toString() {
		return "Carte Premier";
	}
}
