package org.proxibanque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Classe représentant les gérants de la société Proxibanque
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
@Entity
public class Gerant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne
	@JoinColumn(name = "agence_id")
	private Agence agence;

	private String prenom;
	private String nom;

	private String login;
	private String password;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "gerant_id")
	private Set<Conseiller> listeConseiller = new HashSet<>();

	// *** Constructor ***
	public Gerant() {
	}

	public Gerant(String prenom, String nom, String login, String password) {
		this.prenom = prenom;
		this.nom = nom;
		this.login = login;
		this.password = password;
	}

	// *** Getters & Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Conseiller> getListeConseiller() {
		return listeConseiller;
	}

	public void setListeConseiller(Set<Conseiller> listeConseiller) {
		this.listeConseiller = listeConseiller;
	}

	// *** Methods ***
	@Override
	public String toString() {
		return "(" + id + ") " + agence + " [" + prenom + "]" + "(" + nom + ") " + listeConseiller.toString();
	}

}
