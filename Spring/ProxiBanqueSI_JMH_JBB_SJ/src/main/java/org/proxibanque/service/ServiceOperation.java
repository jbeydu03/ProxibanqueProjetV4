package org.proxibanque.service;

import java.util.List;

import org.proxibanque.model.Virement;

/**
 * Interface imposant les méthodes Opération à implémenter
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
public interface ServiceOperation {

	public Virement faireVirement(long idCompteDebit, long idCompteCredit, double montant);
	
	public List<Virement> selectAllVirement();
}
