package org.proxibanque.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.proxibanque.config.Config;
import org.proxibanque.model.Client;
import org.proxibanque.persistence.DaoClient;
import org.proxibanque.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
@WebAppConfiguration
public class ServiceClientTest {

	@Mock
	DaoClient dao;

	@Autowired
	private ServiceImpl service;

	@Before
	public void initialisation() {
		MockitoAnnotations.initMocks(this);
		service.setDaoClient(dao);
	}

	@Test
	public void createClient_should_create_a_client() {

		Client client = new Client();

		when(dao.save(client)).thenReturn(client);

		assertEquals(service.createClient(client, 2), client);

		verify(dao).save(client);
	}

}
