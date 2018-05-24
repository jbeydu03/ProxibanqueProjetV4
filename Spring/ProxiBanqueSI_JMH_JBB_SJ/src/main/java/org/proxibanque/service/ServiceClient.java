package org.proxibanque.service;

import java.util.List;

import org.proxibanque.model.Client;
import org.proxibanque.model.Compte;
import org.proxibanque.model.Virement;
import org.proxibanque.model.CompteEpargne;
import org.proxibanque.persistence.DaoClient;

/**
 * Interface imposant les méthodes à implémenter pour les actions sur les
 * clients en base de données
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
public interface ServiceClient {

	public List<Client> selectAllClient();

	public List<Client> selectAllClientByConseiller(long idConseiller);

	public Client selectClient(long idClient);

	public boolean deleteClient(long idClient)  throws Exception;

	public Client createClient(Client client, long idConseiller);

	public Client updateClient(Client client, long idConseiller);

	public List<Compte> selectAllCompte();

	public Compte createCompteEpargne(Client client);

	public boolean deleteCompteEpargne(Client client);

	public Compte selectCompte(long idCompte);

	public void setClientDao(DaoClient dao);
	
}
