package org.proxibanque.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Classe abstraite représentant les cartes des clients de la société Proxibanque
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Carte {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String numero;
	private boolean active = false;

	// *** Constructor ***
	public Carte() {
	}

	public Carte(String numero) {
		this.numero = numero;
	}

	// *** Getters & Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	// *** Methods ***
	@Override
	public String toString() {
		return "(" + numero + ") " + active;
	}

}
