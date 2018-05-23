package org.proxibanque.controller;

import java.util.ArrayList;
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
	// http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/auth/conseiller/c2/pwd
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
	public ResponseEntity<List<Client>> selectAllClient() {

		List<Client> listeClient = new ArrayList<>();
		listeClient = serviceClient.selectAllClient();

		if (listeClient != null) {
			return new ResponseEntity(listeClient, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	// ==============================================================================
	// RENVOI LA LISTE DES CLIENTS D'UN CONSEILLER A PARTIR DE L'ID D'UN CONSEILLER
	// ==============================================================================
	// URL =>
	// http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/conseiller/2
	// @Secured("ROLE_USER")
	@GetMapping(value = "/clients/conseiller/{idConseiller}", produces = "application/json")
	public ResponseEntity<List<Client>> selectAllClientByConseiller(@PathVariable("idConseiller") long idConseiller) {

		Conseiller conseiller = serviceConseiller.selectConseillerById(idConseiller);

		if (conseiller != null) {
			return new ResponseEntity(serviceConseiller.selectConseillerById(idConseiller), HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

	}

	// ==============================================================================
	// RENVOI UN CLIENT A PARTIR D'UN ID CLIENT
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/2
	// @Secured("ROLE_USER")
	@GetMapping(value = "/clients/{idClient}", produces = "application/json")
	public ResponseEntity<Client> selectClientByIdClient(@PathVariable("idClient") long idClient) {

		// return
		Client client = serviceClient.selectClient(idClient);
		if (client != null) {
			return new ResponseEntity(client, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	// ==============================================================================
	// SUPPRIME UN CLIENT A PARTIR D'UN ID CLIENT
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/2
	// @Secured("ROLE_USER")
	@DeleteMapping(value = "/clients/{idClient}", produces = "application/json")
	public ResponseEntity deleteClient(@PathVariable("idClient") long idClient) {

		try {
			serviceClient.deleteClient(idClient);
			return new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_MODIFIED);
		}
	}

	// ==============================================================================
	// CREER UN CLIENT A PARTIR D'UN CLIENT ET D'UN ID CONSEILLER
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/conseiller/2
	// @Secured("ROLE_USER")
	@PostMapping(value = "/clients/conseiller/{idConseiller}", produces = "application/json")
	public ResponseEntity<Client> createClient(@RequestBody Client client,
			@PathVariable("idConseiller") long idConseiller) {

		Conseiller conseiller = serviceConseiller.selectConseillerById(idConseiller);
		if (conseiller != null) {
			return new ResponseEntity(serviceClient.createClient(client, idConseiller), HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_MODIFIED);
		}

	}

	// ==============================================================================
	// MODIFIER UN CLIENT A PARTIR D'UN ID CLIENT ET D'UN ID CONSEILLER
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/conseiller/2
	// @Secured("ROLE_USER")
	@PutMapping(value = "/clients/conseiller/{idConseiller}", produces = "application/json")
	public ResponseEntity<Client> updateClient(@RequestBody Client client,
			@PathVariable("idConseiller") long idConseiller) {

		Conseiller conseiller = serviceConseiller.selectConseillerById(idConseiller);
		if (conseiller != null) {
			return new ResponseEntity(serviceClient.updateClient(client, idConseiller), HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_MODIFIED);
		}
	}

}
