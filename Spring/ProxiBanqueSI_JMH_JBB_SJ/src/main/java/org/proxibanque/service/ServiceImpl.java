package org.proxibanque.service;

import java.util.List;

import org.proxibanque.model.Client;
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

	private Conseiller selectIdConseillerByNomConseiller(String nomConseiller) {

		Conseiller conseiller = daoConseiller.findByNomIs(nomConseiller);

		return conseiller;
	}

	@Override
	public List<Client> selectAllClientByNomConseiller(String nomConseiller) {

		long id = selectIdConseillerByNomConseiller(nomConseiller).getId();

		return daoClient.findByConseiller_idIs(id);
	}

	@Override
	public Client selectOneClientByIdClient(long idClient) {

		return daoClient.findOne(idClient);
	}

	@Override
	public void deleteOneClientByIdClient(long idClient) {

		daoClient.delete(idClient);
	}

	@Override
	public Client createClient(Client client) {

		return daoClient.save(client);
	}

}
