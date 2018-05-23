package org.proxibanque.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.proxibanque.model.Client;
import org.proxibanque.model.CompteCourant;
import org.proxibanque.model.Conseiller;
import org.proxibanque.persistence.DaoClient;
import org.proxibanque.persistence.DaoConseiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe implémentant les méthodes de service
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
@Service
public class ServiceImpl implements ServiceClient {

	@Autowired
	private DaoClient daoClient;

	@Autowired
	private DaoConseiller daoConseiller;

	@Override
	public List<Client> selectAllClient() {

		return daoClient.findAll();
	}

	@Override
	public List<Client> selectAllClientByConseiller(long idConseiller) {

		return daoClient.findByConseiller_idIs(idConseiller);
	}

	@Override
	public Client selectClient(long idClient) {

		return daoClient.findOne(idClient);
	}

	@Override
	public void deleteClient(long idClient) {

		daoClient.delete(idClient);
	}

	@Override
	public Client createClient(Client client, long idConseiller) {

		String str = "";
		int randomNumber = (int) (Math.random() * 1_000_000_000);
		str = str + String.format("%10d", randomNumber) + "0";

		LocalDateTime dateHeureNow = LocalDateTime.now();
		LocalDate date = dateHeureNow.toLocalDate();

		client.setCompteCourant(new CompteCourant(str, date.toString()));

		Conseiller conseiller = daoConseiller.findOne(idConseiller);

		client.setConseiller(conseiller);

		return daoClient.save(client);
	}

	@Override
	public Client updateClient(Client client, long idConseiller) {
		
		Conseiller conseiller = daoConseiller.findOne(idConseiller);

		client.setConseiller(conseiller);
		
		return daoClient.save(client);
	}

}
