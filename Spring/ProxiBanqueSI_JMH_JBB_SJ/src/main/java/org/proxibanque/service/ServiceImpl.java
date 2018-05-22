package org.proxibanque.service;

import java.util.List;

import org.proxibanque.model.Client;
import org.proxibanque.persistence.DaoClient;
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

	@Override
	public List<Client> selectAllClient() {

		return daoClient.findAll();
	}

	@Override
	public List<Client> selectAllClientByIdConseiller(long idConseiller) {

		return daoClient.findByConseiller_idIs(idConseiller);
	}
}
