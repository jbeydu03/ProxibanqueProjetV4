package org.proxibanque.service;

import java.util.List;
import java.util.Set;

import org.aspectj.lang.annotation.Aspect;
import org.proxibanque.model.Client;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Interface imposant les méthodes à implémenter pour les actions sur les clients en base de données
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
public interface ServiceClient {
	
	public List<Client> selectAllClient();
	
	public List<Client> selectAllClientByConseiller(long idConseiller);
	
	public Client selectClient(long idClient);
	
	public void deleteClient(long idClient);
	
	public Client createClient(Client client, long idConseiller);
	
	public Client updateClient(Client client, long idConseiller);
	
}
