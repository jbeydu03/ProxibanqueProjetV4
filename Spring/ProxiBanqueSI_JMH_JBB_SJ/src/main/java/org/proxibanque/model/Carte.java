package org.proxibanque.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Classe abstraite représentant les cartes des clients de la société
 * Proxibanque
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Carte {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String numero;
	private boolean active = true;

	// *** Constructor ***
	public Carte() {
	}

	public Carte(String numero) {
		this.numero = numero;
	}

	public Carte(long id, String numero, boolean active) {
		super();
		this.id = id;
		this.numero = numero;
		this.active = active;
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
