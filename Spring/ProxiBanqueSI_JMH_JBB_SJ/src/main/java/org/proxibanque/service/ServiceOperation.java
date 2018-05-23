package org.proxibanque.service;

import org.proxibanque.model.Virement;

/**
 * Interface imposant les méthodes à implémenter pour les opérations banquaires
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
public interface ServiceOperation {

	public Virement faireVirement(long idCompteDebit, long idCompteCredit, double montant);
}
