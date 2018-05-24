package org.proxibanque.controller;

import java.util.List;

import org.proxibanque.model.Client;
import org.proxibanque.model.Compte;
import org.proxibanque.model.Conseiller;
import org.proxibanque.model.Virement;
import org.proxibanque.service.ServiceClient;
import org.proxibanque.service.ServiceConseiller;
import org.proxibanque.service.ServiceOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	@Autowired
	ServiceOperation serviceOperation;

	// ==============================================================================
	// AUTHENTIFICATION
	// ==============================================================================
	// URL =>
	// http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/auth/conseiller/c2/pwd
	// @Secured("ROLE_USER")
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/auth/conseiller/{loginConseiller}/{passwordConseiller}", produces = "application/json")
	public ResponseEntity<Conseiller> authentification(@PathVariable("loginConseiller") String loginConseiller,
			@PathVariable("passwordConseiller") String passwordConseiller) {

		try {

			Conseiller conseiller = serviceConseiller.connectionConseiller(loginConseiller, passwordConseiller);
			if (conseiller != null) {
				return new ResponseEntity(conseiller, HttpStatus.ACCEPTED);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.FORBIDDEN);
		}

	}

	// ==============================================================================
	// RENVOI LA LISTE DE TOUS LES CLIENTS DE PROXIBANQUE
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/all
	// @Secured("ROLE_USER")
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/clients/all", produces = "application/json")
	public ResponseEntity<List<Client>> selectAllClient() {

		List<Client> listeClient = serviceClient.selectAllClient();

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
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/clients/conseiller/{idConseiller}", produces = "application/json")
	public ResponseEntity<List<Client>> selectAllClientByConseiller(@PathVariable("idConseiller") long idConseiller) {

		Conseiller conseiller = serviceConseiller.selectConseillerById(idConseiller);

		if (conseiller != null) {
			return new ResponseEntity(serviceClient.selectAllClientByConseiller(idConseiller), HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

	}

	// ==============================================================================
	// RENVOI UN CLIENT A PARTIR D'UN ID CLIENT
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/2
	// @Secured("ROLE_USER")
	@CrossOrigin(origins = "*")
	@GetMapping(value = "/clients/{idClient}", produces = "application/json")
	public ResponseEntity<Client> selectClientByIdClient(@PathVariable("idClient") long idClient) {

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
	@CrossOrigin(origins = "*")
	@DeleteMapping(value = "/clients/{idClient}", produces = "application/json")
	public ResponseEntity deleteClient(@PathVariable("idClient") long idClient) {

		try {
			if (serviceClient.deleteClient(idClient)) {
				return new ResponseEntity(HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.FORBIDDEN);
			}

		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_MODIFIED);
		}
	}

	// ==============================================================================
	// CREER UN CLIENT A PARTIR D'UN CLIENT ET D'UN ID CONSEILLER
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/conseiller/2
	// @Secured("ROLE_USER")
	@CrossOrigin(origins = "*")
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
	@CrossOrigin(origins = "*")
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

	// ==============================================================================
	// RENVOI LA LISTE DE TOUS LES COMPTES
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/2
	// @Secured("ROLE_USER")
	@GetMapping(value = "/comptes/all", produces = "application/json")
	public ResponseEntity<List<Compte>> selectAllCompte() {

		List<Compte> listeCompte = serviceClient.selectAllCompte();
		if (listeCompte != null) {
			return new ResponseEntity(listeCompte, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

	// ==============================================================================
	// AJOUT COMPTE EPARGNE A PARTIR D'UN ID CLIENT
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/comptes/epargne/2
	// @Secured("ROLE_USER")
	@GetMapping(value = "/comptes/epargne/{idClient}", produces = "application/json")
	public ResponseEntity<Compte> addCompteEpargne(@PathVariable("idClient") long idClient) {

		Client client = serviceClient.selectClient(idClient);
		if (client != null) {

			Compte compte = serviceClient.createCompteEpargne(client);
			if (compte != null) {
				return new ResponseEntity(compte, HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.NOT_MODIFIED);
			}
		} else {
			return new ResponseEntity(HttpStatus.NOT_MODIFIED);
		}
	}

	// ==============================================================================
	// SUPPRESSION COMPTE EPARGNE A PARTIR D'UN ID CLIENT
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/comptes/epargne/2
	// @Secured("ROLE_USER")
	@DeleteMapping(value = "/comptes/epargne/{idClient}", produces = "application/json")
	public ResponseEntity deleteCompteEpargne(@PathVariable("idClient") long idClient) {

		Client client = serviceClient.selectClient(idClient);
		if (client != null) {
			if (serviceClient.deleteCompteEpargne(client)) {
				return new ResponseEntity(HttpStatus.OK);
			} else {
				return new ResponseEntity(HttpStatus.NOT_MODIFIED);
			}
		} else {
			return new ResponseEntity(HttpStatus.NOT_MODIFIED);
		}
	}

	// ==============================================================================
	// FAIRE UN VIREMENT
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/comptes/virement/1/2/10
	// @Secured("ROLE_USER")
	@GetMapping(value = "/comptes/virement/{idCompteDebit}/{idCompteCredit}/{montant}", produces = "application/json")
	public ResponseEntity<Virement> faireVirement(@PathVariable("idCompteDebit") long idCompteDebit,
			@PathVariable("idCompteCredit") long idCompteCredit, @PathVariable("montant") double montant) {

		Virement virement = serviceOperation.faireVirement(idCompteDebit, idCompteCredit, montant);

		if (virement != null) {
			return new ResponseEntity(virement, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.FORBIDDEN);
		}
	}

	// ==============================================================================
	// RECUPERER HISTORIQUE VIREMENT
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/comptes/virement/all
	// @Secured("ROLE_USER")
	@GetMapping(value = "/comptes/virement/all", produces = "application/json")
	public ResponseEntity<List<Virement>> addCompteEpargne() {

		List<Virement> listeVirement = serviceOperation.selectAllVirement();

		if (listeVirement != null) {
			return new ResponseEntity(listeVirement, HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

}
