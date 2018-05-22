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

	// *** Methods ***
	@Override
	public String toString() {
		return "Carte Electron";
	}
}
