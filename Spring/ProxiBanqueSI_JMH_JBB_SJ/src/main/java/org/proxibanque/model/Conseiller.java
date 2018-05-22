package org.proxibanque.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


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

	private String login;
	private String password;

	@ManyToOne
	@JoinColumn(name = "gerant_id")
	private Gerant gerant;

	@OneToMany(mappedBy = "conseiller")
	private List<Client> listeClient;

	// *** Constructor ***
	public Conseiller() {
	}

	public Conseiller(String login, String password) {
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

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public List<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}

	// *** Methods ***
	@Override
	public String toString() {
		return "(" + id + ") " + gerant + " [" + login + "]" + "(" + password + ") " + listeClient.toString();
	}

}
