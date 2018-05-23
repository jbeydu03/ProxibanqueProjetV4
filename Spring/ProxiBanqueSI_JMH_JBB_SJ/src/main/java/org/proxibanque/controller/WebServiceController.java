package org.proxibanque.controller;

import java.util.List;

import org.proxibanque.model.Client;
import org.proxibanque.model.Conseiller;
import org.proxibanque.service.ServiceClient;
import org.proxibanque.service.ServiceConseiller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe de WebService de la société Proxibanque
 * 
 * @author Jean-Michel HILTBRUNNER, Jean-Baptiste BLANC, Sebastien JOUMARD
 *
 */
@RestController
public class WebServiceController {

	private static Logger LOGGER = LoggerFactory.getLogger(WebServiceController.class);

	@Autowired
	ServiceClient serviceClient;

	@Autowired
	ServiceConseiller serviceConseiller;

	// ==============================================================================
	// AUTHENTIFICATION
	// ==============================================================================
	// URL =>
	// http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/auth/conseiller/login_conseiller1/password_conseiller1
	// @Secured("ROLE_USER")
	@GetMapping(value = "/auth/conseiller/{loginConseiller}/{passwordConseiller}", produces = "application/json")
	public ResponseEntity<Conseiller> authentification(@PathVariable("loginConseiller") String loginConseiller,
			@PathVariable("passwordConseiller") String passwordConseiller) {

		Conseiller conseiller = serviceConseiller.connectionConseiller(loginConseiller, passwordConseiller);
		if (conseiller != null) {
			return new ResponseEntity(conseiller, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity(HttpStatus.FORBIDDEN);
		}

	}

	// ==============================================================================
	// RENVOI LA LISTE DE TOUS LES CLIENTS DE PROXIBANQUE
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/all
	// @Secured("ROLE_USER")
	@GetMapping(value = "/clients/all", produces = "application/json")
	public List<Client> selectAllClient() {

		return serviceClient.selectAllClient();
	}

	// ==============================================================================
	// RENVOI LA LISTE DES CLIENTS D'UN CONSEILLER A PARTIR DE L'ID D'UN CONSEILLER
	// ==============================================================================
	// URL =>
	// http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/conseiller/2
	// @Secured("ROLE_USER")
	@GetMapping(value = "/clients/conseiller/{idConseiller}", produces = "application/json")
	public List<Client> selectAllClientByConseiller(@PathVariable("idConseiller") long idConseiller) {

		return serviceClient.selectAllClientByConseiller(idConseiller);

	}

	// ==============================================================================
	// RENVOI UN CLIENT A PARTIR D'UN ID CLIENT
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/2
	// @Secured("ROLE_USER")
	@GetMapping(value = "/clients/{idClient}", produces = "application/json")
	public Client selectClientByIdClient(@PathVariable("idClient") long idClient) {

		return serviceClient.selectClient(idClient);
	}

	// ==============================================================================
	// SUPPRIME UN CLIENT A PARTIR D'UN ID CLIENT
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/2
	// @Secured("ROLE_USER")
	@DeleteMapping(value = "/clients/{idClient}", produces = "application/json")
	public void deleteClient(@PathVariable("idClient") long idClient) {

		serviceClient.deleteClient(idClient);
	}

	// ==============================================================================
	// CREER UN CLIENT A PARTIR D'UN CLIENT ET D'UN ID CONSEILLER
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/conseiller/2
	// BODY =>
	// {
	// "nom": "TEST",
	// "prenom": "TEST",
	// "adresse": "1 rue du soleil",
	// "codePostal": "1000",
	// "ville": "BOURG EN BRESSE",
	// "telephone": "01 53 82 74 10"
	// }
	// @Secured("ROLE_USER")
	@PostMapping(value = "/clients/conseiller/{idConseiller}", produces = "application/json")
	public Client createClient(@RequestBody Client client, @PathVariable("idConseiller") long idConseiller) {

		return serviceClient.createClient(client, idConseiller);
	}

	// ==============================================================================
	// MODIFIER UN CLIENT A PARTIR D'UN ID CLIENT ET D'UN ID CONSEILLER
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/conseiller/2
	// BODY =>
	// {
	// "id": 1,
	// "nom": "gergerg",
	// "prenom": "Ozlem",
	// "adresse": "1 rue du soleil",
	// "codePostal": "1000",
	// "ville": "BOURG EN BRESSE",
	// "telephone": "01 53 82 74 10",
	// "compteCourant": {
	// "id": 1,
	// "numero": "1234567890",
	// "solde": 1000,
	// "date": "2018-01-01",
	// "decouvert": -2600,
	// "carte": {
	//
	// "numero": "123456789",
	// "active": false
	// }
	// },
	// "compteEpargne": {
	// "id": 11,
	// "numero": "0000000001",
	// "solde": 1000,
	// "date": "2018-01-01",
	// "taux": 0.01
	// }
	// }
	// @Secured("ROLE_USER")
	@PutMapping(value = "/clients/conseiller/{idConseiller}", produces = "application/json")
	public Client updateClient(@RequestBody Client client, @PathVariable("idConseiller") long idConseiller) {

		return serviceClient.updateClient(client, idConseiller);
	}

}
