package org.proxibanque.service;

import org.proxibanque.model.Conseiller;

/**
 * Interface imposant les méthodes à implémenter pour les actions sur les
 * conseillers en base de données
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
public interface ServiceConseiller {

	public Conseiller selectConseillerById(long idConseiller);
	
	public Conseiller selectConseillerByLogin(String loginConseiller);
	
	public Conseiller connectionConseiller(String loginConseiller, String passwordConseiller);
}
