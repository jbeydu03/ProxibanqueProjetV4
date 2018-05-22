package org.proxibanque.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Classe représentant les conseillers de la société Proxibanque
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
@Entity
public class Conseiller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String prenom;
	private String nom;

	@OneToMany(mappedBy = "conseiller", fetch = FetchType.EAGER)
	@JsonBackReference
	private Set<Client> listeClient = new HashSet<>();;

	// *** Constructor ***
	public Conseiller() {
	}

	public Conseiller(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	// *** Getters & Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Set<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(Set<Client> listeClient) {
		this.listeClient = listeClient;
	}

	// *** Methods ***
	@Override
	public String toString() {
		return "(" + id + ") " + " [" + prenom + "]" + "(" + nom + ") " + listeClient.toString();
	}

}
