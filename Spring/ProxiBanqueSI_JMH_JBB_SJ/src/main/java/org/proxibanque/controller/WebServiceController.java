package org.proxibanque.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

}
