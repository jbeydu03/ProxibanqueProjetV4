package org.proxibanque.launch;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.proxibanque.config.Config;
import org.proxibanque.model.Client;
import org.proxibanque.model.Conseiller;
import org.proxibanque.persistence.DaoClient;
import org.proxibanque.service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Config.class })
@WebAppConfiguration
public class TestCrudClient {
	
	@Mock
	private DaoClient dao;
	
	@Autowired
	private ServiceClient service;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		service.setClientDao(dao);
	}
	
	@Test
	public void addClientShouldAddAClient() {
		Conseiller conseiller = new Conseiller("Darth","Vador","dvador","force");
		Client client = new Client("Racine", "Jean", "Rue du Chene", "75000", "Paris", "0102030405", conseiller);
		service.createClient(client, 3l);
	}
	
	@Test
	public void deleteClientShouldDeleteAClient() throws Exception{
		Conseiller conseiller = new Conseiller("Darth","Vador","dvador","force");
		Client client = new Client("Racine", "Jean", "Rue du Chene", "75000", "Paris", "0102030405", conseiller);
		service.deleteClient(client.getId());
	}
	
	@Test
	public void listClientsShouldListAllClients() {
		Conseiller conseiller = new Conseiller("Darth","Vador","dvador","force");
		Client client = new Client("Racine", "Jean", "Rue du Chene", "75000", "Paris", "0102030405", conseiller);
		Client client2 = new Client("Chaîne", "Jean", "Rue du Chene", "75000", "Paris", "0102030406", conseiller);
		List<Client> liste = new ArrayList<>();
		liste.add(client);
		liste.add(client2);
		service.selectAllClient();
	}
	
	@Test
	public void editClientShouldEditAClient() {
		Conseiller conseiller = new Conseiller("Darth","Vador","dvador","force");
		Client client = new Client("Racine", "Jean", "Rue du Chene", "75000", "Paris", "0102030405", conseiller);
		service.createClient(client, 3L);
		client.setId(1L);
		when(dao.findOne(1L)).thenReturn(client);
		Client clientReturned = service.updateClient(client, 3L);
		System.out.println(client.getId());
		System.out.println(clientReturned.getId());
		assertEquals(clientReturned,client);
	}
	
	
	
}
