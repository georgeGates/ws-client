package org.wsclient.builder;

import java.util.Date;

import org.wsclient.model.Client;

public class ClientBuilderTest {
	
	private Client client;
	private ClientBuilderTest() {}
	
	public static ClientBuilderTest one() {
		ClientBuilderTest builder = new ClientBuilderTest();
		builder.client = new Client();
		builder.client.setName("Cliente");
		builder.client.setCpf("00789012356");
		builder.client.setBirthDate(new Date());
		builder.client.setAddressCep("01001000");
		builder.client.setAddressNumber(37);
		return builder;
	}
	
	public ClientBuilderTest withId(Long id) {
		this.client.setId(id);
		return this;
	}
	
	public ClientBuilderTest withName(String name) {
		this.client.setName(name);
		 return this;
	}

	public Client generator() {
		return this.client;
	}
}
