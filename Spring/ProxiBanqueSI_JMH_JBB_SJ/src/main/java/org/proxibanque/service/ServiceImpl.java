package org.proxibanque.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.proxibanque.model.Client;
import org.proxibanque.model.Compte;
import org.proxibanque.model.CompteCourant;
import org.proxibanque.model.CompteEpargne;
import org.proxibanque.model.Conseiller;
import org.proxibanque.persistence.DaoClient;
import org.proxibanque.persistence.DaoCompte;
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
public class ServiceImpl implements ServiceClient, ServiceConseiller {

	@Autowired
	private DaoClient daoClient;

	@Autowired
	private DaoConseiller daoConseiller;

	@Autowired
	private DaoCompte daoCompte;

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

		client.setCompteCourant(new CompteCourant(generateNumero(), generateDate()));

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

	// ----------------------------------------------------

	@Override
	public Conseiller selectConseillerById(long idConseiller) {

		return daoConseiller.findOne(idConseiller);
	}

	@Override
	public Conseiller selectConseillerByLogin(String loginConseiller) {

		return daoConseiller.findByLoginIs(loginConseiller);
	}

	@Override
	public Conseiller connectionConseiller(String loginConseiller, String passwordConseiller) {

		Conseiller conseiller = selectConseillerByLogin(loginConseiller);

		if (passwordConseiller.equals(conseiller.getPassword())) {
			return conseiller;
		} else {
			return null;
		}
	}

	// ----------------------------------------------------

	@Override
	public List<Compte> selectAllCompte() {

		return daoCompte.findAll();
	}

	@Override
	public Compte createCompteEpargne(Client client) {

		if (client.getCompteEpargne() == null) {

			client.setCompteEpargne(new CompteEpargne(generateNumero(), generateDate()));
			daoClient.save(client);
			return daoCompte.findOne(daoClient.findOne(client.getId()).getCompteEpargne().getId());
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteCompteEpargne(Client client) {

		if (client.getCompteEpargne() != null && client.getCompteEpargne().getSolde() == 0) {

			long idCompte = client.getCompteEpargne().getId();
			client.setCompteEpargne(null);
			daoClient.save(client);
			daoCompte.delete(idCompte);
			
			return true;
			
		} else {

			return false;
		}
	}

	// ----------------------------------------------------

	private String generateNumero() {

		String str = "";
		int randomNumber = (int) (Math.random() * 1_000_000_000);
		str = str + String.format("%10d", randomNumber) + "0";

		return str;
	}

	private String generateDate() {

		LocalDateTime dateHeureNow = LocalDateTime.now();
		LocalDate date = dateHeureNow.toLocalDate();

		return date.toString();
	}

}
