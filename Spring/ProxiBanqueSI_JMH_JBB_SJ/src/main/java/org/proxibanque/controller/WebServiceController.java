package org.proxibanque.controller;

import java.util.List;

import org.proxibanque.model.Client;
import org.proxibanque.model.CompteCourant;
import org.proxibanque.model.CompteEpargne;
import org.proxibanque.model.Conseiller;
import org.proxibanque.service.ServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

	 @GetMapping(value = "/test/", produces = "application/json")
	 public void testWebServiceGET() {
	
	 LOGGER.warn(" ******** testWebServiceGET() ******** ");
	 }
	
	 @GetMapping(value = "/test/{id}", produces = "application/json")
	 public void testWebServiceGET(@PathVariable("id") String id) {
	
	 LOGGER.warn(" ******** testWebServiceGET() ******** ");
	 }
	
	 @PostMapping(value = "/test/", produces = "application/json")
	 public void testWebServicePOST(/*@RequestBody Object obj*/) {
	
	 LOGGER.warn(" ******** testWebServicePOST() ******** ");
	 }
	
	 @DeleteMapping(value = "/test/{id}", produces = "application/json")
	 public void testWebServiceDelete(@PathVariable("id") String id) {
	
	 LOGGER.warn(" ******** testWebServiceDelete() ******** ");
	 }
	
	 @PutMapping(value = "/test/", produces = "application/json")
	 public void testWebServicePUT(/*@RequestBody Object obj*/) {
	
	 LOGGER.warn(" ******** testWebServicePUT() ******** ");
	 }

	@Autowired
	ServiceClient serviceClient;

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
	// RENVOI LA LISTE DES CLIENTS D'UN CONSEILLER A PARTIR DU NOM D'UN CONSEILLER
	// ==============================================================================
	// URL =>
	// http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/conseiller/nom_conseiller2
	// @Secured("ROLE_USER")
	@GetMapping(value = "/clients/conseiller/{nomConseiller}", produces = "application/json")
	public List<Client> selectAllClientByNomConseiller(@PathVariable("nomConseiller") String nomConseiller) {

		return serviceClient.selectAllClientByNomConseiller(nomConseiller);
	}

	// ==============================================================================
	// RENVOI UN CLIENT A PARTIR D'UN ID CLIENT
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/2
	// @Secured("ROLE_USER")
	@GetMapping(value = "/clients/{idClient}", produces = "application/json")
	public Client selectOneClientByIdClient(@PathVariable("idClient") long idClient) {

		return serviceClient.selectOneClientByIdClient(idClient);
	}

	// ==============================================================================
	// SUPPRIME UN CLIENT A PARTIR D'UN ID CLIENT
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/2
	// @Secured("ROLE_USER")
	@DeleteMapping(value = "/clients/{idClient}", produces = "application/json")
	public void deleteOneClientByIdClient(@PathVariable("idClient") long idClient) {

		serviceClient.deleteOneClientByIdClient(idClient);
	}
	
	// ==============================================================================
	// CREER UN CLIENT A PARTIR D'UN CLIENT
	// ==============================================================================
	// URL => http://localhost:8080/ProxiBanqueSI_JMH_JBB_SJ/clients/
	// BODY =>
	//	{
	//	 "nom": "TEST",
	//	    "prenom": "TEST",
	//	    "adresse": "1 rue du soleil",
	//	    "codePostal": "1000",
	//	    "ville": "BOURG EN BRESSE",
	//	    "telephone": "01 53 82 74 10"
	//}
	// @Secured("ROLE_USER")
	@PostMapping(value = "/clients/", produces = "application/json")
	public void createClient(@RequestBody Client client) {

		serviceClient.createClient(client);
	}

	
}
