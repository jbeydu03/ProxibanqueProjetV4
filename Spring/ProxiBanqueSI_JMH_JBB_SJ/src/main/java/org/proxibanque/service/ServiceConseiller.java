package org.proxibanque.service;

import org.proxibanque.model.Conseiller;

/**
 * Interface imposant les méthodes Conseiller à implémenter
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
public interface ServiceConseiller {

	public Conseiller selectConseillerById(long idConseiller);
	
	public Conseiller selectConseillerByLogin(String loginConseiller);
	
	public Conseiller connectionConseiller(String loginConseiller, String passwordConseiller);
}
