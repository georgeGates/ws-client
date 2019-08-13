package org.wsclient.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wsclient.builder.ClientBuilderTest;
import org.wsclient.model.Client;
import org.wsclient.repository.ClientRepository;
import org.wsclient.service.impl.ClientServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class ClientServiceTest {
	
	private Client client;
	
	@InjectMocks
	private ClientServiceImpl service;
	
	@Mock
	private ClientRepository repository;
	
	@Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
        this.client = ClientBuilderTest.one().generator();
    }
	
	private final static Long id = 16l;
	private final static String name = "Cliente";
	private final static String cpf = "00000000000";
	private final static Date birthDate = new Date();
	private final static String addressCep = "00000000";
	private final static int addressNumber = 37;
	
	/*
	 * POST Create new Client
	 */
	@Test
	public void postTest() {
		Client clientOut = ClientBuilderTest.one().withId(1L).generator();
	    when(repository.save(this.client)).thenReturn(clientOut);
		assertEquals(1, service.add(this.client).getId().intValue());
	}
	
	/*
	 * PUT UPDATE Client
	 */
	@Test
	public void putTest() {
		Client clientOut = ClientBuilderTest.one().withId(2L).withName("UPDATE") .generator();
		when(repository.save(this.client)).thenReturn(clientOut);
		assertEquals(clientOut.getName(), service.update(this.client).getName());
	}
	
	

}
