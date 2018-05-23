package org.proxibanque.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Classe représentant les virements entre comptes de la société Proxibanque
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
@Entity
public class Virement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String date;

	private long compteDebitId;

	private long compteCreditId;

	private double montant;

	// *** Constructor ***
	public Virement() {
	}

	public Virement(String date, long compteDebitId, long compteCreditId, double montant) {
		this.date = date;
		this.compteDebitId = compteDebitId;
		this.compteCreditId = compteCreditId;
		this.montant = montant;
	}

	// *** Getters & Setters ***
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public long getCompteDebitId() {
		return compteDebitId;
	}

	public void setCompteDebitId(long compteDebitId) {
		this.compteDebitId = compteDebitId;
	}

	public long getCompteCreditId() {
		return compteCreditId;
	}

	public void setCompteCreditId(long compteCreditId) {
		this.compteCreditId = compteCreditId;
	}

	// *** Methods ***
	@Override
	public String toString() {
		return "  (" + id + ") " + date + compteDebitId + compteCreditId+ "  (" + montant + ") ";
	}

}
