package org.proxibanque.model;

import javax.persistence.Entity;

/**
 * Classe représentant les cartes Electrons des clients de la société Proxibanque
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
@Entity
public class CarteElectron extends Carte {

	// *** Constructor ***
	public CarteElectron() {
		super();
	}

	public CarteElectron(long id, String numero, boolean active) {
		super(id, numero, active);
		// TODO Auto-generated constructor stub
	}

	public CarteElectron(String numero) {
		super(numero);
		// TODO Auto-generated constructor stub
	}

	// *** Methods ***
	@Override
	public String toString() {
		return "Carte Electron";
	}
}
