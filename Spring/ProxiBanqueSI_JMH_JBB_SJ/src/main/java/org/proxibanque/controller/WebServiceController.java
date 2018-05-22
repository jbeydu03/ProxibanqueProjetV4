package org.proxibanque.controller;

import java.util.List;

import org.proxibanque.model.Client;
import org.proxibanque.service.ServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	// @Secured("ROLE_USER")
	// @GetMapping(value = "/test/", produces = "application/json")
	// public void testWebServiceGET() {
	//
	// LOGGER.warn(" ******** testWebServiceGET() ******** ");
	// }
	//
	// @GetMapping(value = "/test/{id}", produces = "application/json")
	// public void testWebServiceGET(@PathVariable("id") String id) {
	//
	// LOGGER.warn(" ******** testWebServiceGET() ******** ");
	// }
	//
	// @PostMapping(value = "/test/", produces = "application/json")
	// public void testWebServicePOST(/*@RequestBody Object obj*/) {
	//
	// LOGGER.warn(" ******** testWebServicePOST() ******** ");
	// }
	//
	// @DeleteMapping(value = "/test/{id}", produces = "application/json")
	// public void testWebServiceDelete(@PathVariable("id") String id) {
	//
	// LOGGER.warn(" ******** testWebServiceDelete() ******** ");
	// }
	//
	// @PutMapping(value = "/test/", produces = "application/json")
	// public void testWebServicePUT(/*@RequestBody Object obj*/) {
	//
	// LOGGER.warn(" ******** testWebServicePUT() ******** ");
	// }

	@Autowired
	ServiceClient serviceClient;

	// @Secured("ROLE_USER")
	@GetMapping(value = "/clients/all", produces = "application/json")
	public List<Client> selectAllClient() {
		
		return serviceClient.selectAllClient();
	}
	
	// @Secured("ROLE_USER")
	@GetMapping(value = "/clients/conseiller/{idConseiller}", produces = "application/json")
	public List<Client> selectAllClientByIdConseiller(@PathVariable("idConseiller") long idConseiller) {
		
		return serviceClient.selectAllClientByIdConseiller(idConseiller);
	}
	
	
	// ------------------------------
	// @Secured("ROLE_USER")
//	@GetMapping(value = "/test/{nomConseiller}", produces = "application/json")
//	public List<Client> selectAllClientByNomConseiller(@PathVariable("nomConseiller") String nomConseiller) {
//		
//		return serviceClient.selectAllClientByNomConseiller(nomConseiller);
//	}
	
	

}
