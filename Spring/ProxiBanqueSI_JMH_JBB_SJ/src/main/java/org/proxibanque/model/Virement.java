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

	private String clientDebitInfo;
	private String compteDebitInfo;

	private String clientCreditInfo;
	private String compteCreditInfo;

	private double montant;

	// *** Constructor ***
	public Virement() {
	}

	public Virement(String date, String clientDebitInfo, String compteDebitInfo, String clientCreditInfo,
			String compteCreditInfo, double montant) {
		this.date = date;
		this.clientDebitInfo = clientDebitInfo;
		this.compteDebitInfo = compteDebitInfo;
		this.clientCreditInfo = clientCreditInfo;
		this.compteCreditInfo = compteCreditInfo;
		this.montant = montant;
	}

	// *** Getters & Setters ***
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompteDebitInfo() {
		return compteDebitInfo;
	}

	public void setCompteDebitInfo(String compteDebitInfo) {
		this.compteDebitInfo = compteDebitInfo;
	}

	public String getCompteCreditInfo() {
		return compteCreditInfo;
	}

	public void setCompteCreditInfo(String compteCreditInfo) {
		this.compteCreditInfo = compteCreditInfo;
	}

	public String getDate() {
		return date;
	}

	public String getClientDebitInfo() {
		return clientDebitInfo;
	}

	public void setClientDebitInfo(String clientDebitInfo) {
		this.clientDebitInfo = clientDebitInfo;
	}

	public String getClientCreditInfo() {
		return clientCreditInfo;
	}

	public void setClientCreditInfo(String clientCreditInfo) {
		this.clientCreditInfo = clientCreditInfo;
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

	// *** Methods ***
	@Override
	public String toString() {
		return "  (" + id + ") " + date + "  (" + montant + ") ";
	}

}
