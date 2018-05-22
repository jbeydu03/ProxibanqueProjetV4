package org.proxibanque.model;

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

	@OneToOne
	@JoinColumn(name = "compteDebit_id")
	private Compte compteDebit;

	@OneToOne
	@JoinColumn(name = "compteCredit_id")
	private Compte compteCredit;

	private double montant;

	// *** Constructor ***
	public Virement() {
	}

	public Virement(String date, Compte compteDebit, Compte compteCredit, double montant) {
		this.date = date;
		this.compteDebit = compteDebit;
		this.compteCredit = compteCredit;
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

	public Compte getCompteDebit() {
		return compteDebit;
	}

	public void setCompteDebit(Compte compteDebit) {
		this.compteDebit = compteDebit;
	}

	public Compte getCompteCredit() {
		return compteCredit;
	}

	public void setCompteCredit(Compte compteCredit) {
		this.compteCredit = compteCredit;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	// *** Methods ***
	@Override
	public String toString() {
		return "  (" + id + ") " + date + compteDebit.toString() + compteCredit.toString() + "  (" + montant + ") ";
	}

}
